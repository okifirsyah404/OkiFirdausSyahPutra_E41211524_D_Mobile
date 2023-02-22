package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var activityBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        supportActionBar?.title = "Minggu 3"

        activityBinding.btnListView.setOnClickListener {
            startActivity(Intent(this, ListViewActivity::class.java))
        }

        activityBinding.btnRecyclerView.setOnClickListener {
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }

    }
}