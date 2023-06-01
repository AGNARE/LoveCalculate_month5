package com.example.lovecalculate_month5.ui.onBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculate_month5.R
import com.example.lovecalculate_month5.databinding.ItemOnboardBinding

class OnBoardAdapter(private val onClick: () -> Unit) :
    Adapter<OnBoardAdapter.OnBoaerdViewHolder>() {

    private val data = arrayListOf(
        OnBoardModel(
            "Have a good time!",
            "You should take the time to help those \n" +
                    " who who need you",
            R.drawable.img_first
        ),
        OnBoardModel(
            "Cherishing love",
            "It is now no longer possible for\nyou to cherish love",
            R.drawable.img_second
        ),
        OnBoardModel(
            "Have a breakup?",
            "We have made the correction for you\n" +
                    " don't worry\n" +
                    " Maybe someone is waiting for you!",
            R.drawable.img_third
        ),
        OnBoardModel(
            "It's Funs and Many more",
            " ",
            R.drawable.img
        )
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoaerdViewHolder {
        return OnBoaerdViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoaerdViewHolder, position: Int) {
        holder.onBind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class OnBoaerdViewHolder(private val binding: ItemOnboardBinding) :
        ViewHolder(binding.root) {
        fun onBind(onBoardModel: OnBoardModel) {
            binding.btnGetStarted.setOnClickListener {
                onClick
            }
            binding.btnGetStarted.isVisible = adapterPosition == data.lastIndex

            binding.tvTitle.text = onBoardModel.title
            binding.tvDescription.text = onBoardModel.desc
            onBoardModel.img?.let { binding.ivGetStarted.setImageResource(it) }

        }

    }

}

