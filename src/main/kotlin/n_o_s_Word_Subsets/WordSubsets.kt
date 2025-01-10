package n_o_s_Word_Subsets

import java.util.HashMap

class WordSubsets {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val res = mutableListOf<String>()
        val w2 = countLetters(words2)

        loop@ for (i in words1.indices) {
            val intArray = IntArray(26)

            words1[i].forEach { intArray[it -'a'] += 1 }

            for (i in w2.indices) {
                if (w2[i] > intArray[i]) continue@loop
            }

            res.add(words1[i])
        }
        return res
    }

    fun countLetters(words2: Array<String>): IntArray {
        val arr = IntArray(26)

        words2.forEach {
            val intArray = IntArray(26)

            it.forEach { intArray[it -'a'] += 1 }

            for (i in arr.indices) {
                if (intArray[i] > arr[i]) arr[i] = intArray[i]
            }
        }

        return arr
    }
}


fun main() {
    val res = WordSubsets().wordSubsets(arrayOf("amazon","apple","facebook","google","leetcode"),
        arrayOf("lo","eo")
    )
    res.forEach{
        print("$it, ")
    }
}