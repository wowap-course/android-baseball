package com.example.baseball.displayBoard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.baseball.databinding.DisplayBoardItemsBinding

class BoardAdapter(private val context: Context, private val boardList: MutableList<BoardItems>) : RecyclerView.Adapter<BoardAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: DisplayBoardItemsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DisplayBoardItemsBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val board = boardList[position]
        holder.binding.apply {
            txtViewTry.text = board.trytime.toString()
            txtViewStrike.text = board.strike.toString()
            txtViewBall.text = board.ball.toString()
            txtViewInputNumber.text = board.answer.joinToString(" ")
        }
    }

    override fun getItemCount(): Int {
        return boardList.size
    }
}
