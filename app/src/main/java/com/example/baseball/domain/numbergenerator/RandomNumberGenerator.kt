package baseball.domain.numbergenerator

class RandomNumberGenerator : NumberGenerator  {
    override fun generateNumber(): List<Int> {
        val number = mutableSetOf<Int>()
        while(number.size < NUMBER_DIGITS) {
            number.add((MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).random())
        }
        return number.toList()
    }

    companion object {
        private const val MIN_RANDOM_NUMBER = 1
        private const val MAX_RANDOM_NUMBER = 9
        private const val NUMBER_DIGITS = 3
    }
}