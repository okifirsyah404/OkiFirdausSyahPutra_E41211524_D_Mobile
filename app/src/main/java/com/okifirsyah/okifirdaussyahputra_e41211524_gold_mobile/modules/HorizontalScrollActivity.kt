package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules

import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.MenuItem
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R

class HorizontalScrollActivity : AppCompatActivity() {

    lateinit var linearLayout: LinearLayout

    fun initComponent() {
        linearLayout = findViewById(R.id.linearLayout)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_scroll)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Table Layout"

        initComponent()

        for (i in 1..25) {
            linearLayout.addView(buttonBuilder("Button ke-$i"))
        }

    }

    private fun buttonBuilder(buttonText: String): Button {
        val button = Button(
            ContextThemeWrapper(
            this,
                R.style.Theme_OkiFirdausSyahPutra_E41211524_GOLD_Mobile_PrimaryButton
        )
        ).apply {
            val roundedCorner = GradientDrawable()
            roundedCorner.cornerRadius = 8f
            roundedCorner.setColor(resources.getColor(R.color.my_primary_500))
            background =  roundedCorner
            text = buttonText

            setOnClickListener {
                Toast.makeText(this@HorizontalScrollActivity, "Anda Telam Menekan Button $buttonText", Toast.LENGTH_SHORT).show()
            }

            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                background = roundedCorner
                setMargins(16, 48, 16, 38)
                isAllCaps = false
            }
        }

        return button
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        android.R.id.home -> {
            finish()
            true
        }

        else -> super.onOptionsItemSelected(item)
    }
}