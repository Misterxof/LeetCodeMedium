package f_th_e_Find_All_Anagrams_String

class FindAllAnagrams {
    fun findAnagrams(s: String, p: String): List<Int> {
        val second = IntArray(26){0}
        val result = mutableListOf<Int>()
        var check = CharArray(p.length)
        var checkIndex = 0

        p.forEach { second[it.code - 'a'.code]++ }

        s.forEachIndexed { i, it ->
            check[checkIndex] = it

            if (i  >= p.length - 1)
                if (isAnagram(charToIntArr(check), second)) result.add(i - (p.length - 1))

            checkIndex++
            if (checkIndex == p.length) checkIndex = 0
        }

        return result
    }

    fun isAnagram(first: IntArray, second: IntArray): Boolean = first.contentEquals(second)

    fun charToIntArr(c: CharArray): IntArray {
        val first = IntArray(26){0}

        c.forEach { first[it.code - 'a'.code]++ }

        return first
    }
}

fun main() {
    println(FindAllAnagrams().findAnagrams(s = "cbaebabacd", p = "abc"))
    println(FindAllAnagrams().findAnagrams(s = "abab", p = "ab"))
}