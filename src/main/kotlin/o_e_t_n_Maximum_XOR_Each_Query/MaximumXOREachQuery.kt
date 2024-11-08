package o_e_t_n_Maximum_XOR_Each_Query

import kotlin.math.pow

class MaximumXOREachQuery {
    fun getMaximumXor(nums: IntArray, maximumBit: Int): IntArray {
        val res = IntArray(nums.size)
        var cur = 0

        for (i in nums.indices) {
            cur = cur xor nums[i]
            res[nums.lastIndex - i] = cur xor (1 shl maximumBit) - 1
        }

        return res
    }
}

fun main() {
    MaximumXOREachQuery().getMaximumXor(intArrayOf(0,1,1,3), 2).forEach { print("$it, ") }
}