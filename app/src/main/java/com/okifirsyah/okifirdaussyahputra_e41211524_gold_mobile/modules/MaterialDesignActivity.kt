package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R

class MaterialDesignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material_design)

        supportActionBar?.title = "Material Design"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        android.R.id.home -> {
            finish()
            true
        }

        else -> super.onOptionsItemSelected(item)
    }
}