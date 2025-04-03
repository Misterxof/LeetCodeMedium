package t_e_se_f_Maximum_Value_Ordered_TripletII

class MaximumValueOrderedTripletII {
    fun maximumTripletValue(nums: IntArray): Long {
        val pref = LongArray(nums.size)
        val suf = LongArray(nums.size)
        var result = 0L

        for (i in 1..nums.lastIndex) {
            pref[i] = maxOf(pref[i - 1], nums[i - 1].toLong())
            suf[nums.size - 1 - i] = maxOf(suf[nums.size - i], nums[nums.size - i].toLong())
        }

        for (j in 1..nums.lastIndex - 1){
            result = maxOf(result, (pref[j] - nums[j].toLong()) * suf[j])
        }

        return result
    }
}