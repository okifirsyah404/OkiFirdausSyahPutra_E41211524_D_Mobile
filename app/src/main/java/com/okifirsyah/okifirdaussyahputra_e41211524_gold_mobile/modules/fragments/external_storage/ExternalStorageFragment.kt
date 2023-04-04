package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments.external_storage

import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentExternalStorageBinding
import java.io.File
import java.io.FileOutputStream

class ExternalStorageFragment : Fragment() {

    var externalStorageBinding: FragmentExternalStorageBinding? = null
    val binding get() = externalStorageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        externalStorageBinding = FragmentExternalStorageBinding.inflate(inflater)
        return externalStorageBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        externalStorageBinding = FragmentExternalStorageBinding.bind(view)

        binding?.btnSavePrivate?.setOnClickListener {
            savePrivateStorage(it)
        }

        binding?.btnSavePublic?.setOnClickListener {
            savePublicStorage(it)
        }

        binding?.btnShowData?.setOnClickListener {
            findNavController().navigate(R.id.action_externalStorageFragment_to_viewExternalStorageFragment)
        }
    }

    private fun savePublicStorage(View: View) {
        activity?.let {
            ActivityCompat.requestPermissions(
                it,
                arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                23,
            )
        }

        val folder: File = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            "MyFolder"
        )
        if (!folder.exists()) {
            folder.mkdir()
        }

        val file: File = File(folder, "MyFilePublic.txt")
        if (!file.exists()) {
            file.createNewFile()
        }

        writeData(file, externalStorageBinding?.edtInputText?.editText?.text.toString())

    }

    private fun savePrivateStorage(View: View) {

        val folder: File = File(
            View.context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS),
            "MyFolder"
        )
        if (!folder.exists()) {
            folder.mkdir()
        }

        val file: File = File(folder, "MyFilePrivate.txt")
        if (!file.exists()) {
            file.createNewFile()
        }

        Log.d("PRV_DIR", "savePrivateStorage: ${file.absolutePath}")

        writeData(file, externalStorageBinding?.edtInputText?.editText?.text.toString())

    }

    private fun writeData(file: File, data: String) {
        var fileOutputStream = FileOutputStream(file)

        try {
            fileOutputStream = FileOutputStream(file)
            fileOutputStream.write(data.toByteArray())
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            fileOutputStream.close()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        externalStorageBinding = null
    }

}