package o_se_Letter_Combinations_Phone_Number

import java.lang.StringBuilder

class LetterCombinationsPhoneNumber {
    private val digitsToLetterMap = mapOf(
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    val result = mutableListOf<String>()
    fun letterCombinations(digits: String): List<String> {
        if (digits.length == 0) return result

        combineAll(0, digits, StringBuilder())

        return result
    }

    private fun combineAll(i: Int, digits: String, res: StringBuilder) {
        if (i == digits.length) {
            result.add(res.toString())
            return
        }

        for (letter in digitsToLetterMap[digits[i]] ?: "") {
            res.append(letter)
            combineAll(i + 1, digits, res)
            res.setLength(i)
        }
    }
}

fun main() {
    println(LetterCombinationsPhoneNumber().letterCombinations("234"))
}