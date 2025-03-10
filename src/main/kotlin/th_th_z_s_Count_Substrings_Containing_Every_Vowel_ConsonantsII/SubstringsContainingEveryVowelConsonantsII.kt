package th_th_z_s_Count_Substrings_Containing_Every_Vowel_ConsonantsII

class SubstringsContainingEveryVowelConsonantsII {
    fun getCountOfSubstrings(word: String, k: Int): Long {
        var j = 0
        var c = 0
        val vowels = charArrayOf('a', 'e', 'i', 'o', 'u')
        val map = HashMap<Char, Int>()
        var result = 0L

        for (i in word.indices) {
            if (vowels.contains(word[i])) {
                map[word[i]] = map.getOrDefault(word[i], 0) + 1
            } else c++

            while (map.size == 5 && c == k) {
                if (vowels.contains(word[j])) {
                    map[word[j]] = map[word[j]]!! - 1
                    if (map[word[j]] == 0) map.remove(word[j])
                } else c--
            }

            result += (i - j) + 1
        }

        return result
    }

    fun countOfSubstrings(word: String, k: Int): Long {
        return getCountOfSubstrings(word, k) - getCountOfSubstrings(word, k + 1)
    }
}