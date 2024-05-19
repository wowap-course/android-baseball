package baseball.domain

@JvmInline
value class BaseballNumber(private val number : Int) {
    init {
        require( number in NUMBER_RANGE)
    }
    companion object {
        private val NUMBER_RANGE = (1..9)
    }
}