package t_z_n_Minimum_Size_Subarray_Sum

class MinimumSizeSubarraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var minLength = Int.MAX_VALUE
        var startPointer = 0
        var length = 0
        var sum = 0
        var i = 0

        while (startPointer != nums.size)  {
            if (sum + nums[i] >= target) {
                minLength = minOf(minLength, length + 1)
                length = 0
                sum = 0
                startPointer++
                i = startPointer
                continue
            }
            else {
                sum += nums[i]
                length++
            }
            i++
            if (i == nums.size && sum < target) break
        }

        return if (minLength != Int.MAX_VALUE) minLength else 0
    }
}

fun main() {
    println(MinimumSizeSubarraySum().minSubArrayLen(213, intArrayOf(12,28,83,4,25,26,25,2,25,25,25,12)))
    println(MinimumSizeSubarraySum().minSubArrayLen(11, intArrayOf(1,1,1,1,1,1,1,1)))
}