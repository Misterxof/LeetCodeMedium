package th_o_n_o_Minimum_OperationsMBAEEOneI

class MinimumOperationsMBAEEOneI {
    fun minOperations(nums: IntArray): Int {
        var ops = 0
        var triple = nums[0] shl 8 or nums[1]
        for (i in 2 until nums.size) {
            triple = triple shl 8 or nums[i]
            if (triple and 0xFF0000 == 0) {
                ops++
                triple = triple xor 0x010101
            }
        }
        return if (triple and 0xFFFF == 0x0101) ops else -1
    }
}