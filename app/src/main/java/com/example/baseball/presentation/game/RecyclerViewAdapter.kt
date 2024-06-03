package com.example.baseball.presentation.game

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.R
import com.example.baseball.databinding.ResultItemsBinding

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.GameResultViewHolder>() {
    private val dataSet: MutableList<Array<Int>> = ArrayList()

    class GameResultViewHolder(private val binding: ResultItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gameScore: Array<Int>) {
            binding.tvTryCount.text =
                binding.root.context.getString(R.string.count_try, adapterPosition + 1)
            binding.tvBall.text = binding.root.context.getString(R.string.count_ball, gameScore[0])
            binding.tvStrike.text =
                binding.root.context.getString(R.string.count_strike, gameScore[1])
            binding.tvAnswer.text =
                binding.root.context.getString(R.string.guessed_answer, gameScore[2])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameResultViewHolder {
        val viewBinding =
            ResultItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameResultViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: GameResultViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    fun addData(gameScore: Array<Int>) {
        dataSet.add(0, gameScore)
        notifyItemInserted(0)
    }
}