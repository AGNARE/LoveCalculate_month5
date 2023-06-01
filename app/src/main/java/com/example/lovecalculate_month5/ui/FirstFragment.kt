package com.example.lovecalculate_month5.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculate_month5.LoveViewModel
import com.example.lovecalculate_month5.R
import com.example.lovecalculate_month5.Utils
import com.example.lovecalculate_month5.databinding.FragmentFirstBinding
import com.example.lovecalculate_month5.remote.LoveModel
import com.example.lovecalculate_month5.remote.RetrofitService
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val viewModel: LoveViewModel by viewModels()

    @Inject
    lateinit var utils: Utils

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
                    viewModel.getLiveLove(firstEt.text.toString(), secondEt.text.toString())
                        .observe(viewLifecycleOwner) { loveModel ->
                            Log.d("ololo", "initClicker: $loveModel")
                            findNavController().navigate(
                                R.id.resultFragment,
                                bundleOf("result" to loveModel)
                            )
                        }
                }
            }
        }
    }
}
//Если оба поля содержат значения, создается экземпляр RetrofitService() и
// вызывается метод getPercentage() для выполнения сетевого запроса.
//                    RetrofitService().api.getPercentage(
//                        first = firstEt.text.toString(),
//                        second = secondEt.text.toString()
//                    ).enqueue(object : retrofit2.Callback<LoveModel> {
//                        override fun onResponse(
//                            call: Call<LoveModel>,
//                            response: Response<LoveModel>
//                        ) {
//                            if (response.isSuccessful) {
//                                findNavController().navigate(
//                                    R.id.resultFragment,
//                                    bundleOf("result" to response.body())
//                                )
//                            }
//                        }
//
//                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {
//                            if (t is IOException) {
//                                Toast.makeText(
//                                    context,
//                                    "Check Internet Connection",
//                                    Toast.LENGTH_SHORT
//                                ).show()
//                            } else {
//                                Toast.makeText(context, "An error occurred", Toast.LENGTH_SHORT)
//                                    .show()
//                            }
//
//                        }
//                    })
//                } else {
//                    Toast.makeText(context, "Please Write Names", Toast.LENGTH_SHORT).show()
//                }
//
//            }
//        }
//    }

//    private fun clearEditText() {
//        val clearEditText = arguments?.getBoolean("clearEditText") ?: false
//        if (clearEditText) {
//            binding.firstEt.text.clear()
//            binding.secondEt.text.clear()
//        }
//    }


