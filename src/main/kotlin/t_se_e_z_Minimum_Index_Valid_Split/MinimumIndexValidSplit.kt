package t_se_e_z_Minimum_Index_Valid_Split

class MinimumIndexValidSplit {
    fun minimumIndex(nums: List<Int>): Int {
        val map = HashMap<Int, Int>()
        var freq = 0
        var curFreq = 0
        var value = 0

        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
            if (map[it]!! > freq) {
                freq = map[it]!!
                value = it
            }
        }

        for (i in 0 until nums.lastIndex) {
            if (nums[i] == value) {
                curFreq++
                freq--
            }

            if (curFreq * 2 > i + 1 && freq * 2 > nums.size - i - 1)
                return i
        }

        return -1
    }
}