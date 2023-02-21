package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputLayout
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R

class ConstraintLayoutActivity : AppCompatActivity() {

    lateinit var textInputLayoutUsername: TextInputLayout
    lateinit var textInputLayoutPassword: TextInputLayout
    lateinit var btnForgotPassword: Button
    lateinit var btnSignIn: CardView

    fun initComponent() {
        textInputLayoutUsername = findViewById(R.id.tilUsername)
        textInputLayoutPassword = findViewById(R.id.tilPassword)
        btnForgotPassword = findViewById(R.id.btnForgetPassword)
        btnSignIn = findViewById(R.id.btnLogin)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Constraint Layout"

        initComponent()

        textInputLayoutUsername.editText?.setText("okifirsyah404")

        btnForgotPassword.setOnClickListener {
            Toast.makeText(this, "Forgot Password", Toast.LENGTH_SHORT).show()
        }

        btnSignIn.setOnClickListener {

            val usernamePlain = textInputLayoutUsername.editText?.text.toString()
            val passwordPlain = textInputLayoutPassword.editText?.text.toString()

            if (usernamePlain.isNotEmpty() && passwordPlain.isNotEmpty()) {

                if (passwordPlain == "123456") {
                    Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Username or Password wrong", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Username and password null", Toast.LENGTH_SHORT).show()
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