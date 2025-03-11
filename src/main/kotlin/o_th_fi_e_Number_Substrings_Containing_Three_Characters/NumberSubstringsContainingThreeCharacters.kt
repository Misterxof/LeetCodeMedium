package o_th_fi_e_Number_Substrings_Containing_Three_Characters

class NumberSubstringsContainingThreeCharacters {
    fun numberOfSubstrings(s: String): Int {
        var j = 0
        val vowels = charArrayOf('a', 'b', 'c')
        val map = HashMap<Char, Int>()
        var result = 0

        for (i in s.indices) {
            if (vowels.contains(s[i])) {
                map[s[i]] = map.getOrDefault(s[i], 0) + 1
            }

            while (map.size == 3) {
                result++
                if (vowels.contains(s[j])) {
                    map[s[j]] = map[s[j]]!! - 1
                    if (map[s[j]] == 0) map.remove(s[j])
                }
                j++
            }
        }

        return result
    }
}