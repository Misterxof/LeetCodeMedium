package o_se_f_n_Maximum_Absolute_Sum_Any_Subarray

import kotlin.math.abs

class MaximumAbsoluteSumAnySubarray {
    fun maxAbsoluteSum(nums: IntArray): Int {
        var max = 0
        var min = 0
        var sum = 0

        for (i in nums.indices) {
            sum += nums[i]
            max = maxOf(max, sum)
            min = minOf(min, sum)
        }

        return abs(min) + abs(max)
    }
}