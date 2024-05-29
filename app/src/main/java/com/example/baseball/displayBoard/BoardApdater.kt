package com.example.baseball.displayBoard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.baseball.databinding.DisplayBoardItemsBinding

class BoardApdater(private val context: Context, private val boardList: MutableList<com.example.baseball.displayBoard.BoardItems>): BaseAdapter() {
    private var mBinding: DisplayBoardItemsBinding? = null
    private val binding get() = mBinding!!

    override fun getView(position: Int, covertView: View?, parent: ViewGroup?): View {
        mBinding = DisplayBoardItemsBinding.inflate(LayoutInflater.from(context))

        val trytime = binding.txtViewTry
        val strike = binding.txtViewStrike
        val ball = binding.txtViewBall
        val answer = binding.txtViewInputNumber

        val board = boardList[position]

        trytime.text = board.trytime.toString()
        strike.text = board.strike.toString()
        ball.text = board.ball.toString()
        answer.text = board.answer.joinToString(" ")


        return mBinding!!.root
    }

    override fun getItem(p0: Int): Any {
        return boardList[p0]
    }

    override fun getCount(): Int {
        return boardList.size
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }
}