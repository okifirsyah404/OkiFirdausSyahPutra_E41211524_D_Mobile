package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments.external_storage

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentViewExternalStorageBinding
import java.io.File
import java.io.FileInputStream
import java.io.IOException


class ViewExternalStorageFragment : Fragment() {

    private var _binding: FragmentViewExternalStorageBinding? = null
    private val viewExternalStorageBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentViewExternalStorageBinding.inflate(inflater)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentViewExternalStorageBinding.bind(view)

        _binding?.btnExternalStorageReadPublic?.setOnClickListener {
            getPublicData()
        }

        _binding?.btnExternalStorageReadPrivate?.setOnClickListener {
            getPrivateData()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun getData(myFile: File): String? {
        var fileInputStream: FileInputStream? = null
        try {
            fileInputStream = FileInputStream(myFile)
            var i = -1
            val buffer = StringBuffer()
            while (fileInputStream.read().also { i = it } != -1) {
                buffer.append(i.toChar())
            }
            return buffer.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return null
    }

    private fun getPublicData() {
        val folder: File = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            "MyFolder"
        )

        val myFile = File(folder, "MyFilePublic.txt")

        if (myFile.exists()) {
            val data = getData(myFile)
            viewExternalStorageBinding?.tvExternalStorageResult?.text = data
        }
    }

    private fun getPrivateData() {
        val folder: File = File(
            context?.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),
            "MyFolder"
        )

        val myFile = File(folder, "MyFilePrivate.txt")

        Log.d("PRV_DIR", "savePrivateStorage: ${myFile.absolutePath}")

        if (myFile.exists()) {
            val data = getData(myFile)
            Log.d("PRV_DIR", "savePrivateStorage: ${myFile.absolutePath}")
            viewExternalStorageBinding?.tvExternalStorageResult?.text = data
        } else {
            Log.d("PRV_DIR", "savePrivateStorage: File not found")
        }
    }

}