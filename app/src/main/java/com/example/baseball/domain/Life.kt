package com.example.baseball.domain

data class Life(var life: Int) {
    init {
        require(life in MIN_LIFE_COUNT..MAX_LIFE_COUNT)
    }

    operator fun inc(): Life {
        if (life == MAX_LIFE_COUNT) return this
        return Life(life + 1)
    }

    operator fun dec(): Life {
        if (life == MIN_LIFE_COUNT) return this
        return Life(life - 1)
    }

    companion object {
        private const val MIN_LIFE_COUNT = 1
        private const val MAX_LIFE_COUNT = 10
    }

}