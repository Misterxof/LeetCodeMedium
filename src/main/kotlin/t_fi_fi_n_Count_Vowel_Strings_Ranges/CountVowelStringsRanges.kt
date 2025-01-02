package t_fi_fi_n_Count_Vowel_Strings_Ranges

class CountVowelStringsRanges {
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val answers = BooleanArray(words.size)
        val result = IntArray(queries.size)

        words.forEachIndexed { index, s ->
            if (s.length == 1) answers[index] = isVowel(s[0])
            if (isVowel(s.first()) && isVowel(s.last())) answers[index] = true
            else answers[index] = false
        }

        queries.forEachIndexed { index, ints ->
            var counter = 0
            for (i in ints[0]..ints[1])  {
                if (answers[i])
                    counter++
            }
            result[index] = counter
        }

        return result
    }

    // fast as * boy
    fun vowelStrings2(words: Array<String>, queries: Array<IntArray>): IntArray {
        val answers = IntArray(words.size)
        val result = IntArray(queries.size)
        var counter = 0

        // pre count all answers (first and last char is vowel)
        words.forEachIndexed { index, s ->
            if (isVowel(s.first()) && isVowel(s.last())) counter++
            answers[index] = counter
        }

        /*
            if range first bound 0 then return answers[last bound] counter
            if previous answer count == first bound answer count (current is not vowel) then just subtract
            else current is vowel so subtract + 1 (vowel)
        */
        queries.forEachIndexed { index, ints ->
            if (ints[0] == 0) result[index] = answers[ints[1]]
            else if (answers[ints[0] - 1] == answers[ints[0]]) result[index] = answers[ints[1]] - answers[ints[0]]
            else result[index] = answers[ints[1]] - answers[ints[0]] + 1
        }

        return result
    }

    fun isVowel(char: Char): Boolean {
        return when(char) {
            'a', 'e', 'i', 'o','u' -> true
            else -> false
        }
    }
}

fun main() {
    var test1 = CountVowelStringsRanges().vowelStrings2(
        arrayOf("aba","bcb","ece","aa","e"),
        arrayOf(
            intArrayOf(0,2),
            intArrayOf(1,4),
            intArrayOf(1,1),
        )
    )
    test1.forEach {
        print("$it, ")
    }
}

