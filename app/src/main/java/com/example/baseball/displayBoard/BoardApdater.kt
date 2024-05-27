package com.example.baseball.displayBoard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.baseball.databinding.DisplayBoardItemsBinding

class BoardApdater(val context: Context, val BoardList: List<BoardItems>): BaseAdapter() {
    private var mBinding: DisplayBoardItemsBinding? = null
    private val binding get() = mBinding!!

    override fun getView(position: Int, covertView: View?, parent: ViewGroup?): View {
        mBinding = DisplayBoardItemsBinding.inflate(LayoutInflater.from(context))

        val trytime = binding.txtViewTry
        val strike = binding.txtViewStrike
        val ball = binding.txtViewBall
        val inputNumner = binding.txtViewInputNumber

        val board = BoardList[position]

        trytime.text = board.trytime.toString()
        strike.text = board.strike.toString()
        ball.text = board.ball.toString()
        inputNumner.text = board.toString()


        return mBinding!!.root
    }

    override fun getItem(p0: Int): Any {
        return BoardList[p0]
    }

    override fun getCount(): Int {
        return BoardList.size
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }
}