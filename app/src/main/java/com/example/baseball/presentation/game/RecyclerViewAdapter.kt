package com.example.baseball.presentation.game

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.R

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.GameResultViewHolder>() {
    private val dataSet : MutableList<Array<String>> = ArrayList<Array<String>>()
    class GameResultViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val tvTryCount : TextView = view.findViewById(R.id.tvTryCount)
        private val tvBall : TextView = view.findViewById(R.id.tvBall)
        private val tvStrike : TextView = view.findViewById(R.id.tvStrike)
        private val tvAnswer : TextView = view.findViewById(R.id.tvAnswer)

        fun bind(gameScore : Array<String>) {
            tvTryCount.text = gameScore[0]
            tvBall.text = gameScore[1]
            tvStrike.text = gameScore[2]
            tvAnswer.text = gameScore[3]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_items, parent, false)
        return GameResultViewHolder(view)
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: GameResultViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    fun addData(gameScore: Array<String>) {
        dataSet.add(0, gameScore)
        notifyItemInserted(0)
    }
}