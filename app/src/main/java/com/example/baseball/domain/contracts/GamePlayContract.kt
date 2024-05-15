package com.example.baseball.domain.contracts

interface GamePlayContract {

    interface View {
        fun showLife(life: Int)
    }

    interface Presenter {
        fun decreaseLife()
    }
}