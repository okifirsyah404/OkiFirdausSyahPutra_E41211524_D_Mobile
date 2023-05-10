package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.utils

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun Context.showOKDialog(title: String, message: String) {
    AlertDialog.Builder(this).apply {
        setTitle(title)
        setMessage(message)
        setPositiveButton("OK") { p0, _ ->
            p0.dismiss()
        }
    }.create().show()
}