package o_f_z_z_Construct_Palindrome_Strings

class ConstructPalindromeStrings {
    fun canConstruct(s: String, k: Int): Boolean {
        val lattesArray = IntArray(26)
        var oddCount = 0

        if (s.length < k) return false

        s.forEach {
            lattesArray[it - 'a'] += 1
        }

        for (i in lattesArray.indices) {
            if (lattesArray[i] % 2 != 0) oddCount++
        }

        return oddCount <= k
    }
}