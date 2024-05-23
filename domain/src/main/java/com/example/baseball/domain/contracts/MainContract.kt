package com.example.baseball.domain.contracts

interface MainContract {

    interface View {
        fun showLife(life: Int)
    }

    interface Presenter {
        fun increaseLife()
        fun decreaseLife()
    }
}