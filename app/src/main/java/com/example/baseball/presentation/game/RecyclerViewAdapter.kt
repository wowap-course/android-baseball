package com.example.baseball.presentation.game

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.databinding.ResultItemsBinding

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.GameResultViewHolder>() {
    private val dataSet : MutableList<Array<Int>> = ArrayList()

    class GameResultViewHolder(private val binding : ResultItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        private val tvTryCount = binding.tvTryCount
        private val tvBall = binding.tvBall
        private val tvStrike = binding.tvStrike
        private val tvAnswer = binding.tvAnswer

        fun bind(gameScore : Array<Int>) {
            tvTryCount.text = "${gameScore[0]} 번째 도전"
            tvBall.text = "볼 : ${gameScore[1]}"
            tvStrike.text = "스트라이크 : ${gameScore[2]}"
            tvAnswer.text = "입력 : ${gameScore[3]}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameResultViewHolder {
        val viewBinding = ResultItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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