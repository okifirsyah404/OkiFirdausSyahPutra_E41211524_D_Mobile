package com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.modules.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.okifirsyah.okifirdaussyahputra_e41211524_gold_mobile.databinding.FragmentSecondBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {

    private var _secondFragmentBinding: FragmentSecondBinding? = null
    private val binding get() = _secondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _secondFragmentBinding = FragmentSecondBinding.inflate(inflater)
        return _secondFragmentBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _secondFragmentBinding = FragmentSecondBinding.bind(view)

        binding?.btnShowSecondFragment?.setOnClickListener {
            Toast.makeText(context, "Second Fragment", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _secondFragmentBinding = null
    }
}