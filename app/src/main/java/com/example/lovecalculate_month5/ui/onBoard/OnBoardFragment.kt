package com.example.lovecalculate_month5.ui.onBoard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculate_month5.Pref
import com.example.lovecalculate_month5.R
import com.example.lovecalculate_month5.databinding.FragmentOnBoardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding
    private lateinit var adapter: OnBoardAdapter

    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        adapter = OnBoardAdapter(this::onClick)
        binding.viewPager2.adapter = adapter

        binding.indicator.setViewPager(binding.viewPager2)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

        if (pref.isUserSeen()) {
            findNavController().navigate(R.id.firstFragment)
        }

    }

    private fun onClick() {
        pref.isUserSeenOnBoard()
        findNavController().navigate(R.id.onBoardFragment)

    }

}