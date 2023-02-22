package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.textfield.TextInputLayout
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ActivityConstraintLayoutBinding

class ConstraintLayoutActivity : AppCompatActivity() {

    lateinit var layoutBinding : ActivityConstraintLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutBinding = ActivityConstraintLayoutBinding.inflate(layoutInflater)
        setContentView(layoutBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Constraint Layout"

        layoutBinding.tilPassword.editText?.setText("okifirsyah404")

        layoutBinding.btnForgetPassword.setOnClickListener {
            Toast.makeText(this, "Forgot Password", Toast.LENGTH_SHORT).show()
        }

        layoutBinding.btnLogin.setOnClickListener {

            val usernamePlain = layoutBinding.tilUsername.editText?.text.toString()
            val passwordPlain = layoutBinding.tilPassword.editText?.text.toString()

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