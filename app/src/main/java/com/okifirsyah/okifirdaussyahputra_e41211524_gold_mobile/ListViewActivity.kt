package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity(), AdapterView.OnItemClickListener {

    lateinit var activityBinding: ActivityListViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        supportActionBar?.title = "List View"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val listView = activityBinding.listView
        val adapterView = ArrayAdapter.createFromResource(
            this,
            R.array.country_names,
            android.R.layout.simple_list_item_1
        )

        listView.adapter = adapterView
        listView.onItemClickListener = this
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        Toast.makeText(
            this,
            "Anda memilih ${parent?.getItemAtPosition(position)}",
            Toast.LENGTH_SHORT
        ).show()
    }
}