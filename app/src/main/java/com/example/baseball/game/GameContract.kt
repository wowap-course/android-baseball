package com.example.baseball.game

import com.example.baseball.game.baseballcounts.BaseballCountItem

interface GameContract {

    interface View {
        fun showResult(baseballCountItems: List<BaseballCountItem>)
        fun showLife(lifeCount: Int)
        fun showWinDialog(randomNumber: List<Int>)
        fun showLoseDialog(randomNumber: List<Int>)
    }

    interface Presenter {
        fun challenge(inputNumber: List<Int>)
    }
}
