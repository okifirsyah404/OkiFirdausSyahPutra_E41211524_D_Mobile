package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Layouts"

        binding.btnLinearLayout.setOnClickListener {
            startActivity(Intent(this, LinearLayoutActivity::class.java))
        }

        binding.btnRelativeLayout.setOnClickListener {
            startActivity(Intent(this, RelativeLayoutActivity::class.java))
        }

        binding.btnConstraintLayout.setOnClickListener {
            startActivity(Intent(this, ConstraintLayoutActivity::class.java))
        }

        binding.btnTableLayout.setOnClickListener {
            startActivity(Intent(this, TableLayoutActivity::class.java))
        }

        binding.btnScrollViewLayout.setOnClickListener {
            startActivity(Intent(this, ScrollViewActivity::class.java))
        }

        binding.btnHorizontalScrollViewLayout.setOnClickListener {
            startActivity(Intent(this, HorizontalScrollActivity::class.java))
        }

        binding.btnRecyclerViewList.setOnClickListener {
            startActivity(Intent(this, ListRecyclerViewActivity::class.java))
        }

        binding.btnRecyclerViewGrid.setOnClickListener {
            startActivity(Intent(this, GridRecyclerViewActivity::class.java))
        }

        binding.btnMaterialDesign.setOnClickListener {
            startActivity(Intent(this, MaterialDesignActivity::class.java))
        }
    }
}