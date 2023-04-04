package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments.sqlite_room.main_view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.R
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentMainRoomBinding
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.adapter.NoteAdapter
import org.koin.android.ext.android.inject

class MainRoomFragment : Fragment() {
    private val viewModel: MainRoomViewModel by inject()

    private var binding: FragmentMainRoomBinding? = null
    val fragmentMainRoomBinding get() = binding!!

    lateinit var rvAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainRoomBinding.inflate(inflater)
        return fragmentMainRoomBinding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainRoomBinding.bind(view)

        rvAdapter = NoteAdapter(this)

        binding?.rvNotes?.apply {
            adapter = rvAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }

        viewModel.getAllNotes().observe(viewLifecycleOwner) {
            if (it != null) {
                rvAdapter.setListNotes(it)
            }
        }

        binding?.fabAdd?.setOnClickListener {
            findNavController().navigate(R.id.action_mainRoomFragment_to_noteAddUpdateFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}