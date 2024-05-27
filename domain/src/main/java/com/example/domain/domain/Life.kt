package com.example.baseball.domain

data class Life(val value: Int) {
    init {
        require(value in MIN_LIFE_COUNT..MAX_LIFE_COUNT)
    }

    operator fun inc(): Life {
        if (value == MAX_LIFE_COUNT) return this
        return Life(value + 1)
    }

    operator fun dec(): Life {
        if (value == MIN_LIFE_COUNT) return this
        return Life(value - 1)
    }

    companion object {
        private const val MIN_LIFE_COUNT = 1
        private const val MAX_LIFE_COUNT = 10
    }

}