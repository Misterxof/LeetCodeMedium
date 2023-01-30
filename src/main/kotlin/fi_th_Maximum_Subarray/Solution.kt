package t_o_se_Contains_Duplicate

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = Int.MIN_VALUE
        var previousSum = 0

        nums.forEachIndexed { index, i ->
            val currentSum = previousSum + i

            previousSum = if (currentSum < i) i else currentSum

            if (maxSum < previousSum)
                maxSum = previousSum
        }

        return maxSum
    }

    fun maxSubArray1(nums: IntArray): Int {
        var sum = Int.MIN_VALUE

        nums.forEachIndexed { index, i ->
            var sumT = 0
            for (j in index..(nums.size - 1)) {

                sumT += nums[j]

                if (sumT > sum)
                    sum = sumT

            }
        }

        return sum
    }

    fun maxSubArray2(nums: IntArray): Int {
        var list: MutableList<Int> = mutableListOf()

        nums.forEachIndexed { index, i ->
            var size = list.size
            var j = index

            if (size == 0) {
                list.add(i)
                return@forEachIndexed
            }

            while (j != 0) {
                list.add(i + list[size - j])
                j--
            }

            list.add(i)
        }

        return list.max()
    }
}