package com.example.baseball.domain

class Life(var count: Int) {

    fun decrease(): Life {
        if (count > MIN_LIFE) {
            count--
        }
        return Life(count)
    }

    fun increase(): Life {
        if (count < MAX_LIFE) {
            count++
        }
        return Life(count)
    }

    fun decreaseToZero(): Int {
        if (count > ZERO_LIFE) {
            count--
        }
        return count
    }

    companion object {
        const val ZERO_LIFE = 0
        const val MIN_LIFE = 1
        const val MAX_LIFE = 10
    }
}