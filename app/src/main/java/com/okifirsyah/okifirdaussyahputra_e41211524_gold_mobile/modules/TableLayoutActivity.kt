package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R

class TableLayoutActivity : AppCompatActivity() {

    lateinit var edtUsername: TextInputLayout
    lateinit var edtPassword: TextInputLayout
    lateinit var btnSubmit: Button

    fun initComponent() {
        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnSubmit = findViewById(R.id.btnSubmit)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_layout)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Horizontal Scroll View Layout"

        initComponent()

        btnSubmit.setOnClickListener {
            val username = edtUsername.editText?.text.toString()
            val password = edtPassword.editText?.text.toString()

            if (username == "admin" && password == "admin") {
                Toast.makeText(this, "Login berhasil", Toast.LENGTH_SHORT).show()
                edtUsername.error = null
                edtPassword.error = null
                edtUsername.editText?.setText("")
                edtPassword.editText?.setText("")
            } else {
                edtUsername.error = "Username atau password salah"
                edtPassword.error = "Username atau password salah"
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        android.R.id.home -> {
            finish()
            true
        }

        else -> super.onOptionsItemSelected(item)
    }
}