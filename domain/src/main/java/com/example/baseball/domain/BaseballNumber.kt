package baseball.domain

@JvmInline
value class BaseballNumber(val value: Int) {
    init {
        require(value in MIN_BASEBALL_NUMBER..MAX_BASEBALL_NUMBER) { ERROR_NOT_IN_RANGE }
    }

    companion object {
        private const val MIN_BASEBALL_NUMBER = 1
        private const val MAX_BASEBALL_NUMBER = 9
        private const val ERROR_NOT_IN_RANGE =
            "$MIN_BASEBALL_NUMBER 부터 $MAX_BASEBALL_NUMBER 사이 숫자여야합니다"
    }
}
