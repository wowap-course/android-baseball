package baseball.domain.numbergenerator

class UniqueRandomNumbersGenerator(
    private val numbers: List<Int>,
    private val length: Int,
) : NumberGenerator {
    override fun generate(): List<Int> = numbers.shuffled().take(length)
}
