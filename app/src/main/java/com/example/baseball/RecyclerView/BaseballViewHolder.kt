package com.example.baseball.RecyclerView

import Count
import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.R
import com.example.baseball.databinding.ItemRecyclerviewBinding

class BaseballViewHolder(val binding: ItemRecyclerviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(count: Count) {
        binding.tryTitle.text =
            binding.root.context.getString(R.string.recyclerview_try_title, adapterPosition + 1)
        binding.strikeCount.text =
            binding.root.context.getString(R.string.recyclerview_strike_count, count.strikeCount)
        binding.ballCount.text =
            binding.root.context.getString(R.string.recyclerview_ball_count, count.ballCount)

        binding.inputNumber.text =
            binding.root.context.getString(
                R.string.recyclerview_input_number,
                count.inputNumber.joinToString("").toInt()
            )

    }

}