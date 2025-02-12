package t_th_f_t_Max_Sum_Pair_Equal_Sum_Digits

import java.util.TreeSet

class MaxSumPairEqualSumDigits {
    fun maximumSum(nums: IntArray): Int {
        val map = HashMap<Int, MutableList<Int>>()
        var max = -1

        nums.forEach { num ->
            val sum = sumOfDigits(num)
            map[sum] = map.getOrDefault(sum, ArrayDeque<Int>()).apply {
                add(num)
            }
        }

        map.forEach { k,v ->
            if (v.size > 1) {
                v.sort()
                max = maxOf(max, v[v.lastIndex] + v[v.lastIndex - 1])
            }
        }

        return max
    }

    fun sumOfDigits(number: Int): Int {
        var sum = 0
        var n = number

        while (n != 0) {
            val digit = n % 10
            sum += digit
            n /= 10
        }

        return sum
    }
}