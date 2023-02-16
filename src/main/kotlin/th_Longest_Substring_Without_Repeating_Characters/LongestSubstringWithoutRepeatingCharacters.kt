package th_Longest_Substring_Without_Repeating_Characters

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring2(s: String): Int {
        var hash = hashMapOf<Char, MutableSet<Char>>()
        var max = 0
        for (i in s.indices) {
            val temp = copyHash(hash)
            hash.forEach {
                if (!it.value.add(s[i])) {
                    println(s[i])
                    max = maxOf(max, it.value.size)
                    temp.remove(it.key)
                }
            }
            hash = temp
            hash[s[i]] = mutableSetOf(s[i])
        }

        hash.values.forEach {
            max = maxOf(max, it.size)
        }

        return max
    }

    // faster
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var max = 0
        var i = 0
        var j = 0

        while (j < s.length) {
            if (!set.contains(s[j])){
                set.add(s[j++])
                max = maxOf(max, set.size)
            } else {
                set.remove(s[i++])
            }
        }

        return max
    }

    private fun copyHash(hashMap: HashMap<Char, MutableSet<Char>>): HashMap<Char, MutableSet<Char>> {
        val result = hashMapOf<Char, MutableSet<Char>>()

        hashMap.forEach {
            result[it.key] = it.value
        }

        return result
    }
}

fun main() {
    println(LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"))
    println(LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"))
    println(LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aab"))
}