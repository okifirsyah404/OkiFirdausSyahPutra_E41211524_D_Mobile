package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.data.MahasiswaData
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ActivityRecyclerViewBinding
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.models.Mahasiswa
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.rv_adapter.ListStudentAdapter

class RecyclerViewActivity : AppCompatActivity() {

    lateinit var activityBinding: ActivityRecyclerViewBinding
    var studentList: ArrayList<Mahasiswa> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(activityBinding.root)

        supportActionBar?.title = "Recycler View"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        studentList.addAll(MahasiswaData.listData)

        activityBinding.rvStudents.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this)
        activityBinding.rvStudents.adapter = ListStudentAdapter(studentList)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        android.R.id.home -> {
            finish()
            true
        }

        else -> super.onOptionsItemSelected(item)
    }
}