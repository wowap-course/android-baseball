package com.example.baseball.domain.model

@JvmInline
value class Life(val value: Int) {

    init {
        require(value in MIN_LIFE..MAX_LIFE) { "Life requires in range 0 to 10" }
    }

    operator fun inc(): Life {
        return Life(value + 1)
    }

    operator fun dec(): Life {
        return Life(value - 1)
    }

    companion object {
        private const val MAX_LIFE = 10
        private const val MIN_LIFE = 1
    }
}

