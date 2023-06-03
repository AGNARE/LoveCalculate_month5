package com.example.lovecalculate_month5.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculate_month5.databinding.FragmentResultBinding
import com.example.lovecalculate_month5.remote.LoveModel

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            val result = arguments?.getSerializable("result") as LoveModel
            etYou.text = result.firstName
            etMe.text = result.secondName
            tvPercentage.text = result.percentage + "%"
            tvResult.text = result.result

            //переход назад и передача сигнала об очистке edit text через bundle
            btnTryAgain.setOnClickListener {
                val bundle = Bundle().apply {
                    putBoolean("clearEditText", true)
                }
                findNavController().navigateUp()
            }
        }
    }
}