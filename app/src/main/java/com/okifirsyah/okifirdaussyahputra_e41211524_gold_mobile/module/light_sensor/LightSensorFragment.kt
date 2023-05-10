package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.light_sensor

import android.content.res.AssetFileDescriptor
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.LegendRenderer
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentLightSensorBinding
import java.io.IOException


class LightSensorFragment : Fragment(), SensorEventListener {

    private var _lightSensorFragmentBinding: FragmentLightSensorBinding? = null
    val binding get() = _lightSensorFragmentBinding

    private lateinit var viewModel: LightSensorViewModel

    private lateinit var sensorManager: SensorManager
    private var lightSensor: Sensor? = null
    private var graphLastAccelXValue = 5.0
    private var mPlayer: MediaPlayer? = null
    private var mGraphLight: GraphView? = null
    private var mSeriesLight: LineGraphSeries<DataPoint>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _lightSensorFragmentBinding = FragmentLightSensorBinding.inflate(inflater, container, false)
        return _lightSensorFragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _lightSensorFragmentBinding = FragmentLightSensorBinding.bind(view)

        sensorManager =
            getSystemService(requireContext(), SensorManager::class.java) as SensorManager
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        if (lightSensor == null) {
            _lightSensorFragmentBinding?.txtBrightnessInfo?.setText("Sensor Tidak Tersedia");
        } else {
            sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }

        mGraphLight =
            _lightSensorFragmentBinding?.graphLight?.id?.let { initGraph(it, "Sensor Of Light") }
        mSeriesLight = initSeries(Color.RED, "Lux")
        mGraphLight?.addSeries(mSeriesLight);

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _lightSensorFragmentBinding = null
        sensorManager.unregisterListener(this, lightSensor)
    }

    private fun initGraph(id: Int, title: String): GraphView? {
        val graph = view?.findViewById<GraphView>(id)
        graph?.viewport?.isXAxisBoundsManual = true
        graph?.viewport?.setMinX(0.0)
        graph?.viewport?.setMaxX(5.0)
        graph?.gridLabelRenderer?.setLabelVerticalWidth(100)
        graph?.title = title
        graph?.gridLabelRenderer?.isHorizontalLabelsVisible = false
        graph?.legendRenderer?.isVisible = true
        graph?.legendRenderer?.align = LegendRenderer.LegendAlign.TOP
        return graph
    }

    fun initSeries(color: Int, title: String?): LineGraphSeries<DataPoint> {
        val series: LineGraphSeries<DataPoint> = LineGraphSeries()
        series.apply {
            isDrawDataPoints = true
            isDrawBackground = true
            backgroundColor = Color.argb(100, 204, 119, 119)
        }

        series.color = color
        series.title = title
        return series
    }

    override fun onSensorChanged(sensorEvent: SensorEvent) {
        val sensorType = sensorEvent.sensor.type
        when (sensorType) {
            Sensor.TYPE_LIGHT -> {
                _lightSensorFragmentBinding?.txtBrightnessInfo?.text = requireContext().getString(
                    R.string.label_brightness,
                    sensorEvent.values[0]
                )
                //graph view
                graphLastAccelXValue += 0.15
                mSeriesLight?.appendData(
                    DataPoint(
                        graphLastAccelXValue,
                        sensorEvent.values[0].toDouble()
                    ),
                    true, 33
                )
                if (sensorEvent.values[0] == 0f) {
                    mPlayer = MediaPlayer()
                    try {
                        val `as`: AssetFileDescriptor =
                            requireActivity().assets.openFd("cahaya_gelap.mp3")

                        mPlayer?.apply {
                            setDataSource(`as`.fileDescriptor, `as`.startOffset, `as`.length)
                            `as`.close()
                            prepare()
                            start()
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                } else if (sensorEvent.values[0] > 150) {
                    mPlayer = MediaPlayer()
                    try {
                        val `as`: AssetFileDescriptor =
                            requireActivity().assets.openFd("cahaya_terang.mp3")

                        mPlayer?.apply {
                            setDataSource(`as`.fileDescriptor, `as`.startOffset, `as`.length)
                            `as`.close()
                            prepare()
                            start()
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                }
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
//        TODO("Not yet implemented")
    }

}