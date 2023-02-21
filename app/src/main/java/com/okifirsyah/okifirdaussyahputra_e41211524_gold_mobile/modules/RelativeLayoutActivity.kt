package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import java.util.*

class RelativeLayoutActivity : AppCompatActivity() {

    lateinit var tvCalendar: TextView
    lateinit var edtCalendar: TextInputLayout
    lateinit var btnPickCalendar: Button

    fun initComponent() {
        tvCalendar = findViewById(R.id.tvCalendarTitle)
        edtCalendar = findViewById(R.id.edtCalendar)
        btnPickCalendar = findViewById(R.id.btnPickCalendar)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Relative Layout"

        initComponent()

        edtCalendar.editText?.setOnClickListener {
            showDatePicker()

        }

        btnPickCalendar.setOnClickListener {
            showDatePicker()
        }

    }

    fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val dateTimeFormatter = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale("id"))

        val datePickerDialog = DatePickerDialog(this, { _, pickedYear, pickedMonth, dayOfMonth ->
            calendar.set(pickedYear, pickedMonth, dayOfMonth)
            edtCalendar.editText?.setText(dateTimeFormatter.format(calendar.time))
        }, year, month, day)

        datePickerDialog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        android.R.id.home -> {
            finish()
            true
        }

        else -> super.onOptionsItemSelected(item)
    }
}