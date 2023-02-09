package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btnIncrement: Button
    lateinit var btnDecrement: Button
    lateinit var tvResult: TextView

    fun initComponent() {
        btnIncrement = findViewById(R.id.btnIncrement)
        btnDecrement = findViewById(R.id.btnDecrement)
        tvResult = findViewById(R.id.tvResult)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Minggu 1"

        initComponent()

        tvResult.text = "0"

        btnIncrement.setOnClickListener {
            increment()
        }

        btnDecrement.setOnClickListener {
            decrement()
        }
    }

    fun increment() {
        var result = tvResult.text.toString().toInt()
        result++
        tvResult.text = result.toString()
    }

    fun decrement() {
        var result = tvResult.text.toString().toInt()

        if (result > 0) result--

        tvResult.text = result.toString()
    }

}