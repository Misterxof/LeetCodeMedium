package t_th_s_f_Count_Number_Bad_Pairs

class CountNumberBadPairs {
    fun countBadPairs(nums: IntArray): Long {
        var result = 0L
        val map = HashMap<Int, Int>()

        for (i in nums.indices) {
            val dif = i - nums[i]
            val good = map.getOrDefault(dif, 0)
            result += i - good
            map[dif] = good + 1
        }

        return result
    }
}