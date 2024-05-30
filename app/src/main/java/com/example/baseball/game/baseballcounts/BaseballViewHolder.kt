package com.example.baseball.game.baseballcounts

import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.R
import com.example.baseball.databinding.ItemRecyclerviewBinding

class BaseballViewHolder(
    private val binding: ItemRecyclerviewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(baseballCountItem: BaseballCountItem) {
        val context = binding.root.context

        binding.tryTitle.text = context.getString(R.string.try_title, adapterPosition + 1)
        binding.strikeCount.text = context.getString(
            R.string.strike_count,
            baseballCountItem.strikeCount
        )
        binding.ballCount.text = context.getString(R.string.ball_count, baseballCountItem.ballCount)
        binding.inputNumber.text = context.getString(
            R.string.input_number,
            baseballCountItem.inputNumber.joinToString("").toInt()
        )
    }
}
