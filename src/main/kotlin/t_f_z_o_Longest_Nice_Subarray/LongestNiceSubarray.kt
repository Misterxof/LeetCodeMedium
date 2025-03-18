package t_f_z_o_Longest_Nice_Subarray

class LongestNiceSubarray {
    fun longestNiceSubarray(nums: IntArray): Int {
        var max = 1
        var left = 0
        var right = 0
        var x = 0

        while (right < nums.size) {
            while (left < right && x and nums[right] > 0) {
                x = x xor nums[left++]
            }

            x = x or nums[right++]
            max = maxOf(max, right - left)
        }

        return max
    }
}