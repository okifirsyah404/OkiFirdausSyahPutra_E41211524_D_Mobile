package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments.sqlite_room.add_edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.Note
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentNoteAddUpdateBinding
import org.koin.android.ext.android.inject
import timber.log.Timber

class NoteAddUpdateFragment : Fragment() {

    companion object {
        const val EXTRA_NOTE = "extra_note"
        const val ALERT_DIALOG_CLOSE = 10
        const val ALERT_DIALOG_DELETE = 20
    }

    private val viewModel: NoteAddUpdateViewModel by inject()

    private var binding: FragmentNoteAddUpdateBinding? = null
    val fragmentNoteAddUpdateBinding get() = binding!!

    private val args: NoteAddUpdateFragmentArgs by navArgs()

    private var isEdit = false
    private var note: Note? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteAddUpdateBinding.inflate(inflater)
        return fragmentNoteAddUpdateBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNoteAddUpdateBinding.bind(view)

        note = args.note

        if (note != null) {
            isEdit = true
            binding?.edtTitle?.editText?.setText(note?.title)
            binding?.edtDescription?.editText?.setText(note?.description)
            binding?.btnDelete?.visibility = View.VISIBLE
        } else {
            note = Note()
            binding?.btnDelete?.visibility = View.GONE
        }

        val btnTitle: String = if (isEdit) {
            getString(R.string.update)
        } else {
            getString(R.string.save)
        }

        binding?.btnSubmit?.text = btnTitle

        Timber.tag("EDIT").d("isEdit: $isEdit")

        binding?.btnSubmit?.setOnClickListener {
            val title = binding?.edtTitle?.editText?.text.toString().trim()
            val description = binding?.edtDescription?.editText?.text.toString().trim()

            if (title.isEmpty()) {
                binding?.edtTitle?.error = getString(R.string.empty)
            } else {
                note?.title = title
                note?.description = description

                if (isEdit) {
                    viewModel.update(note as Note)
                    showToast(getString(R.string.changed))
                } else {
                    viewModel.insert(note as Note)
                    showToast(getString(R.string.added))
                }

                findNavController().navigateUp()
            }
        }

        binding?.btnDelete?.setOnClickListener {
            showAlertDialog(ALERT_DIALOG_DELETE)
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    private fun showAlertDialog(type: Int) {
        val isDialogClose = type == ALERT_DIALOG_CLOSE
        val dialogTitle: String
        val dialogMessage: String
        if (isDialogClose) {
            dialogTitle = getString(R.string.cancel)
            dialogMessage = getString(R.string.message_cancel)
        } else {
            dialogMessage = getString(R.string.message_delete)
            dialogTitle = getString(R.string.delete)
        }
        val alertDialogBuilder = activity?.let { AlertDialog.Builder(it) }
        with(alertDialogBuilder) {
            this?.setTitle(dialogTitle)
            this?.setMessage(dialogMessage)
            this?.setCancelable(false)
            this?.setPositiveButton(getString(R.string.yes)) { _, _ ->
                if (!isDialogClose) {
                    viewModel.delete(note as Note)
                    showToast(getString(R.string.deleted))
                }
                findNavController().navigateUp()
            }
            this?.setNegativeButton(getString(R.string.no)) { dialog, _ -> dialog.cancel() }
                ?: return
        }
        alertDialogBuilder?.create()?.show()
    }

    private fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

}