package o_e_n_Rotate_Array

class RotateArray {
    fun rotate(nums: IntArray, k: Int): Unit {
        val res = IntArray(nums.size)
        var dif = k % nums.size

        for (i in nums.indices) {
            if (i < dif) res[i] = nums[nums.size - dif + i]
            else res[i] = nums[i - dif]
        }

        for (i in nums.indices) nums[i] = res[i]
    }
}

fun main() {
    RotateArray().rotate(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3)
    RotateArray().rotate(intArrayOf(-1,-100,3,99), 2)
    RotateArray().rotate(intArrayOf(-1), 2)
    RotateArray().rotate(intArrayOf(1,2,3,4,5,6), 11)
    RotateArray().rotate(intArrayOf(1,2), 0)
}