package com.example.lovecalculate_month5.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.example.lovecalculate_month5.App
import com.example.lovecalculate_month5.LoveViewModel
import com.example.lovecalculate_month5.data.local.AppDataBase
import com.example.lovecalculate_month5.data.local.LoveDao
import com.example.lovecalculate_month5.databinding.FragmentHistoryBinding
import com.example.lovecalculate_month5.remote.LoveModel
import javax.inject.Inject

class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding
    @Inject
    lateinit var dataBase: LoveDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = dataBase.getAllSort()
        var data = ""

        list.forEach {
            data += "${it.firstName}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tПроцент:\n❤\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t${it.percentage}\n${it.secondName}\n\n"
        }

        binding.resultTv.text = data
    }

}