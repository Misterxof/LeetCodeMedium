package t_t_se_e_z_Number_Ways_Split_Array

class NumberWaysSplitArray {
    fun waysToSplitArray(nums: IntArray): Int {
        val leftSum = LongArray(nums.size)
        val rightSum = LongArray(nums.size)
        var sum = 0L

//        if (nums.size == 2) {
//            return if (nums[0] >= nums[1]) 1 else 0
//        }

        nums.forEachIndexed { index, i ->
            sum += i
            leftSum[index] = sum
        }

        sum = 0

        for (i in nums.lastIndex downTo 0) {
            sum += nums[i]
            rightSum[i] = sum
        }

        sum = 0

        for (i in 0 until nums.lastIndex) {
//            println("l ${leftSum[i]} r ${rightSum[i]}")
            if (leftSum[i] >= rightSum[i + 1]) sum++
        }

        return sum.toInt()
    }
}

fun main() {
    println(NumberWaysSplitArray().waysToSplitArray(intArrayOf(10,4,-8,7)))
    println(NumberWaysSplitArray().waysToSplitArray(intArrayOf(2,3,1,0)))
    println(NumberWaysSplitArray().waysToSplitArray(intArrayOf(2, 3, 4)))
    println(NumberWaysSplitArray().waysToSplitArray(intArrayOf(0, -1, -2, -3, -4)))
}