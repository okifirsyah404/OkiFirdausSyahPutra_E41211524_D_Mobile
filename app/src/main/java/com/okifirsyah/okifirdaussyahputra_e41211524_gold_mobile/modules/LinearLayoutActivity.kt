package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R

class LinearLayoutActivity : AppCompatActivity() {

    lateinit var edtReceiver : EditText
    lateinit var edtSubject: EditText
    lateinit var edtMessage: EditText
    lateinit var btnSend: Button

    fun initComponent() {
        edtReceiver = findViewById(R.id.receiver_edit_text)
        edtSubject = findViewById(R.id.subject_edit_text)
        edtMessage = findViewById(R.id.main_message_edit_text)
        btnSend = findViewById(R.id.btn_send)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)

        initComponent()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Linear Layout"

        btnSend.setOnClickListener {
            if (edtReceiver.text.isNotEmpty() || edtSubject.text.isNotEmpty()) {
                Toast.makeText(this ,"Send to ${edtReceiver.text} with ${edtSubject.text} subject", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this ,"Receiver and subject cannot be null", Toast.LENGTH_SHORT).show()
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