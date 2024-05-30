package baseball.domain

data class BaseballScore(
    val strike: Int,
    val ball: Int,
) {
    fun isCorrect() = this == BaseballScore(CORRECT_STRIKE_COUNT, CORRECT_BALL_COUNT)

    companion object {
        private const val CORRECT_STRIKE_COUNT = 3
        private const val CORRECT_BALL_COUNT = 0
    }
}
