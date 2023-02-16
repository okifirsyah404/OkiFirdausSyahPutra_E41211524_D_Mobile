package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btnLinearLayout: TextView
    lateinit var btnRelativeLayout: TextView
    lateinit var btnConstraintLayout: TextView

    fun initComponent() {
        btnLinearLayout = findViewById(R.id.btnLinearLayout)
        btnRelativeLayout = findViewById(R.id.btnRelativeLayout)
        btnConstraintLayout = findViewById(R.id.btnConstraintLayout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponent()

        supportActionBar?.title = "Layouts"

        btnLinearLayout.setOnClickListener {
            startActivity(Intent(this, LinearLayoutActivity::class.java))
        }

        btnRelativeLayout.setOnClickListener {
            startActivity(Intent(this, RelativeLayoutActivity::class.java))
        }

        btnConstraintLayout.setOnClickListener {
            startActivity(Intent(this, ConstraintLayoutActivity::class.java))
        }
    }
}