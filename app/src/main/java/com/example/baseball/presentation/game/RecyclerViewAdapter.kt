package com.example.baseball.presentation.game

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.databinding.ResultItemsBinding
import com.example.baseball.domain.BaseballNumber
import com.example.baseball.domain.BaseballScore

class RecyclerViewAdapter : RecyclerView.Adapter<GameResultViewHolder>() {
    private val dataSet : ArrayList<BaseballScore> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameResultViewHolder {
        val viewBinding =
            ResultItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameResultViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: GameResultViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    fun addData(tryCount : Int, ball: Int, strike: Int, answer: List<Int>) {
        dataSet.add(0, BaseballScore(tryCount, ball, strike, answer.map { BaseballNumber(it) }))
        notifyItemInserted(0)
    }
}