package f_n_Group_Anagrams

class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()
        val res = mutableListOf<List<String>>()

        strs.forEach {
            val s = it.toCharArray().sorted().joinToString("")
            map[s] = map.getOrDefault(s, mutableListOf()).apply { add(s) }
        }

        map.forEach {
            res.add(it.value)
        }

        return res
    }
}