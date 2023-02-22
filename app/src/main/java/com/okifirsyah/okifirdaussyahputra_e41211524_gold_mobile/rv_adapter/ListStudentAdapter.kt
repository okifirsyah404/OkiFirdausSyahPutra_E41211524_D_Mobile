package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.rv_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.ItemCardListStudentBinding
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.models.Mahasiswa

class ListStudentAdapter(private val listStudent: ArrayList<Mahasiswa>) :
    RecyclerView.Adapter<ListStudentAdapter.ListStudentViewHolder>() {

    inner class ListStudentViewHolder(private val binding: ItemCardListStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mahasiswa: Mahasiswa) {
            with(binding) {
                tvName.text = mahasiswa.name
                tvNIM.text = mahasiswa.nim
                tvPhoneNumber.text = mahasiswa.phoneNumber
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListStudentViewHolder {
        val view =
            ItemCardListStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListStudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

    override fun onBindViewHolder(holder: ListStudentViewHolder, position: Int) {
        val mahasiswa = listStudent[position]

        holder.bind(mahasiswa)

        holder.itemView.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Kamu adalah ${mahasiswa.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}