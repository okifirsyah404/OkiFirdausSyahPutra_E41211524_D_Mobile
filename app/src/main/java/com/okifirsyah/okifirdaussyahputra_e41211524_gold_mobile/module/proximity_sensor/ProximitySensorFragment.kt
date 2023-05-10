package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.proximity_sensor

import android.content.res.AssetFileDescriptor
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
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentProximitySensorBinding
import java.io.IOException


class ProximitySensorFragment : Fragment(), SensorEventListener {

    private var _binding: FragmentProximitySensorBinding? = null
    private val binding get() = _binding

    private var mPlayer: MediaPlayer? = null
    private lateinit var sensorManager: SensorManager
    private var sensorProximity: Sensor? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProximitySensorBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentProximitySensorBinding.bind(view)

        binding?.txtInformation?.text = "Loading.."


        sensorManager =
            getSystemService(requireContext(), SensorManager::class.java) as SensorManager
        sensorProximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        if (sensorProximity == null) {
            binding?.txtInformation?.setText("Sensor Tidak Tersedia")
        } else {
            sensorManager.registerListener(this, sensorProximity, SensorManager.SENSOR_DELAY_NORMAL)
        }

    }

    override fun onSensorChanged(sensorEvent: SensorEvent) {
        val sensorType = sensorEvent.sensor.type
        when (sensorType) {
            Sensor.TYPE_PROXIMITY -> {
                binding?.txtInformation?.text = resources.getString(
                    R.string.label_proximity,
                    sensorEvent.values[0]
                )
                if (sensorEvent.values[0] == 0f) {
                    mPlayer = MediaPlayer()
                    try {
                        val `as`: AssetFileDescriptor =
                            requireActivity().assets.openFd("objek_mendekat.mp3")
                        mPlayer?.apply {
                            setDataSource(`as`.fileDescriptor, `as`.startOffset, `as`.length)
                            `as`.close()
                            prepare()
                            start()
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }
                } else {
                    mPlayer = MediaPlayer()
                    try {
                        val `as`: AssetFileDescriptor =
                            requireActivity().assets.openFd("objek_menjauh.mp3")
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
    }

}