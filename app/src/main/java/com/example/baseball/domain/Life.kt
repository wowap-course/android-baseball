package com.example.baseball.domain

class Life(private var count: Int) {

    fun decrease() {
        if (count > MIN_LIFE) {
            count--
        }
    }

    fun increase() {
        if (count < MAX_LIFE) {
            count++
        }
    }

    companion object {
        const val MIN_LIFE = 1
        const val MAX_LIFE = 10
    }
}