package com.example.baseball.domain.model

@JvmInline
value class Life(val value: Int) {

    init {
        require(value in MIN_LIFE..MAX_LIFE) { "Life requires in range 0 to 10" }
    }

    operator fun inc(): Life {
        if (value == MAX_LIFE) {
            return this
        }
        return Life(value + 1)
    }

    operator fun dec(): Life {
        if (value == MIN_LIFE) {
            return this
        }
        return Life(value - 1)
    }

    operator fun plus(other: Int): Life {
        return Life(value + other)
    }

    companion object {
        private const val MAX_LIFE = 10
        private const val MIN_LIFE = 1
    }
}
