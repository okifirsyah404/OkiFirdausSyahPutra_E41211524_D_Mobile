package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ActivityProfileBinding


class ProfileActivity : AppCompatActivity() {

    private var _activityProfileBinding: ActivityProfileBinding? = null
    private val binding get() = _activityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityProfileBinding = ActivityProfileBinding.inflate(layoutInflater)

        setContentView(_activityProfileBinding?.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Profile"

        binding?.btnWhatsapp?.setOnClickListener {
            intentWhatsApp()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        android.R.id.home -> {
            finish()
            true
        }

        else -> super.onOptionsItemSelected(item)
    }

    fun intentWhatsApp() {
        val uri =
            "whatsapp://send?text=Hello World! My name is ${getString(R.string.profile_name)}&phone=+6282143212404"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(uri)
        startActivity(intent)
    }
}