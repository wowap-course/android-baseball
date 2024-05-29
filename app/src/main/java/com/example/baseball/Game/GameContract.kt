package com.example.baseball.Game

import BaseballCountUiModel

interface GameContract {
    interface View {

        fun showResult(baseballCountUiModels: List<BaseballCountUiModel>)
        fun showLife(lifeCount: Int)
        fun showWinDialog(randomNumber: List<Int>)
        fun showLoseDialog(randomNumber: List<Int>)

    }

    interface Presenter {
        fun challenge(inputNumber: List<Int>)
    }
}
