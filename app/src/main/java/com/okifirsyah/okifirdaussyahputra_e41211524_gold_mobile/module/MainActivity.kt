package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.BooksData
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.model.Book
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ActivityMainBinding
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.adapter.GridBookAdapter
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.module.adapter.ListBookAdapter

class MainActivity : AppCompatActivity() {

    private var _activityMainBinding: ActivityMainBinding? = null
    private val binding get() = _activityMainBinding

    private var list: ArrayList<Book> = arrayListOf()

    companion object {
        private const val STATE_MODE = "state_mode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(_activityMainBinding?.root)

        _activityMainBinding?.rvBooks?.setHasFixedSize(true)
        list.addAll(BooksData.listData)

        if (savedInstanceState != null) {
            val itemLayout = savedInstanceState.getParcelable<Parcelable>(STATE_MODE)
            showRecyclerGrid()
            _activityMainBinding?.rvBooks?.layoutManager?.onRestoreInstanceState(itemLayout)
        } else {
            showRecyclerList()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val stateMode = _activityMainBinding?.rvBooks?.layoutManager?.onSaveInstanceState()
        outState.putParcelable(STATE_MODE, stateMode)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_profile -> {
            val profileIntent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(profileIntent)
            true
        }
        R.id.action_list -> {
            showRecyclerList()
            true
        }
        R.id.action_grid -> {
            showRecyclerGrid()
            true
        }
        else -> super.onOptionsItemSelected(item)

    }

    private fun showRecyclerList() {
        _activityMainBinding?.rvBooks?.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this)
        _activityMainBinding?.rvBooks?.adapter = ListBookAdapter(list)
    }

    private fun showRecyclerGrid() {
        _activityMainBinding?.rvBooks?.layoutManager =
            androidx.recyclerview.widget.GridLayoutManager(this, 2)
        _activityMainBinding?.rvBooks?.adapter = GridBookAdapter(list)
    }
}