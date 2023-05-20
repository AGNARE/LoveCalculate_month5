package com.example.lovecalculate_month5

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculate_month5.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Response

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                if (firstEt.text.isNotEmpty() && secondEt.text.isNotEmpty()) {
                    RetrofitService().api.getPercentage(
                        first = firstEt.text.toString(),
                        second = secondEt.text.toString()
                    ).enqueue(object : retrofit2.Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            if (response.isSuccessful) {
                                Log.d("ololo", "onResponse: ${response.body()}")
                                findNavController().navigate(
                                    R.id.resultFragment,
                                    bundleOf("result" to response.body())
                                )
                            }
                        }

                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                            Log.d("ololo", "onFailure: ${t.message}")
                        }
                    })
                }else{
                    Toast.makeText(context, "Please Write Names", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}