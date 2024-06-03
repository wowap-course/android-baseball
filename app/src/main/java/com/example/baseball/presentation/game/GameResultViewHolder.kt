package com.example.baseball.presentation.game

import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.R
import com.example.baseball.databinding.ResultItemsBinding
import com.example.baseball.domain.BaseballScore

class GameResultViewHolder(private val binding: ResultItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gameScore: BaseballScore) {
            binding.tvTryCount.text =
                binding.root.context.getString(R.string.count_try, gameScore.tryCount)
            binding.tvBall.text = binding.root.context.getString(R.string.count_ball, gameScore.ball)
            binding.tvStrike.text =
                binding.root.context.getString(R.string.count_strike, gameScore.strike)
            binding.tvAnswer.text =
                binding.root.context.getString(R.string.guessed_answer, gameScore.answerOfInning.joinToString(""))
        }
    }