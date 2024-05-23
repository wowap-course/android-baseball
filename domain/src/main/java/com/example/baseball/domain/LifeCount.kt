package com.example.baseball.domain

@JvmInline
value class LifeCount(val count: Int = 1) {
    init {
        require(count in MIN_LIFE_COUNT..MAX_LIFE_COUNT)
    }

    operator fun inc(): LifeCount {
        return if (count >= MAX_LIFE_COUNT) LifeCount(MAX_LIFE_COUNT) else LifeCount(count + 1)
    }

    operator fun dec(): LifeCount {
        return if (count <= MIN_LIFE_COUNT) LifeCount(MIN_LIFE_COUNT) else LifeCount(count - 1)
    }

    companion object {
        private const val MIN_LIFE_COUNT = 1
        private const val MAX_LIFE_COUNT = 10
    }
}