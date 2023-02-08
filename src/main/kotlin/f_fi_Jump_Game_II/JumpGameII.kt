package f_fi_Jump_Game_II

class JumpGameII {

    fun jump(nums: IntArray): Int {
        return allJumps(nums, 0, IntArray(nums.size))
    }

    fun allJumps(nums: IntArray, index: Int, results: IntArray): Int {
        if (index >= nums.size - 1) return 0
        if (results[index] != 0) return results[index]

        var minimal = Int.MAX_VALUE

        for (i in 1..nums[index]) {
            minimal = minOf(minimal, allJumps(nums, index + i, results) + 1)
        }

        results[index] = minimal

        return results[index]
    }
}

fun main() {
    println(JumpGameII().jump(intArrayOf(2,3,1,1,4)))
    println(JumpGameII().jump(intArrayOf(2,1)))
    println(JumpGameII().jump(intArrayOf(3,2,1)))
    println(JumpGameII().jump(intArrayOf(1,2,1,1,1)))
    println(JumpGameII().jump(intArrayOf(5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0)))
    println(JumpGameII().jump(intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0)))
    println(JumpGameII().jump(intArrayOf(9,8,2,2,0,2,2,0,4,1,5,7,9,6,6,0,6,5,0,5)))
}