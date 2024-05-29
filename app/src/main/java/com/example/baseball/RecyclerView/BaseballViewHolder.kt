package com.example.baseball.RecyclerView

import BaseballCountUiModel
import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.R
import com.example.baseball.databinding.ItemRecyclerviewBinding

class BaseballViewHolder(val binding: ItemRecyclerviewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(baseballCountUiModel: BaseballCountUiModel) {
        binding.tryTitle.text =
            binding.root.context.getString(R.string.try_title, adapterPosition + 1)
        binding.strikeCount.text =
            binding.root.context.getString(R.string.strike_count, baseballCountUiModel.strikeCount)
        binding.ballCount.text =
            binding.root.context.getString(R.string.ball_count, baseballCountUiModel.ballCount)

        binding.inputNumber.text =
            binding.root.context.getString(
                R.string.input_number,
                baseballCountUiModel.inputNumber.joinToString("").toInt()
            )

    }

}
