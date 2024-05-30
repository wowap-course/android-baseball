package baseball.domain

class BaseballNumbers(val numbers: Set<BaseballNumber>) {

    init {
        require(numbers.size == NUMBERS_SIZE) { ERROR_NOT_VALID_SIZE }
    }

    operator fun get(index: Int) = numbers.toList()[index]

    companion object {
        const val NUMBERS_SIZE = 3
        private const val ERROR_DUPLICATE = "숫자야구 숫자는 중복될 수 없습니다"
        private const val ERROR_NOT_VALID_SIZE = "숫자야구의 숫자 개수는 3개입니다"

        @JvmName("fromBaseballNumbers")
        fun from(numbers: List<BaseballNumber>): BaseballNumbers {
            require(numbers.toSet().size == numbers.size) { ERROR_DUPLICATE }
            return BaseballNumbers(numbers = numbers.toSet())
        }

        @JvmName("fromInts")
        fun from(numbers: List<Int>): BaseballNumbers {
            val wrappedNumbers = numbers.map { BaseballNumber(it) }
            require(numbers.toSet().size == numbers.size) { ERROR_DUPLICATE }
            return BaseballNumbers(wrappedNumbers.toSet())
        }
    }
}
