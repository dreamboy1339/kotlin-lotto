package stringaddcalculator

class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0
        if (text.length == 1) return validate(text)

        val result: MatchResult? = Regex("//(.)\n(.*)").find(text)
        result?.let {
            val customDelimiter: String = it.groupValues[1]
            val tokens = it.groupValues[2].split(customDelimiter)
            return addNumbers(tokens)
        }

        val numbers: List<String> = text.split("[,:]".toRegex())
        return addNumbers(numbers)
    }

    @Throws(RuntimeException::class)
    private fun addNumbers(text: List<String>): Int {
        var result = 0
        text.forEach { char ->
            val number: Int = validate(text = char)
            result += number
        }
        return result
    }

    @Throws(RuntimeException::class)
    private fun validate(text: String): Int {
        val number = text.toIntOrNull() ?: throw RuntimeException("not number type !!")
        if (number < 0) throw RuntimeException("negative number !!")
        return number
    }
}
