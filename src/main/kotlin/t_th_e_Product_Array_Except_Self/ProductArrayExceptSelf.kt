package t_th_e_Product_Array_Except_Self

class ProductArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        var pref = 1
        val res = IntArray(nums.size)

        nums.forEachIndexed { index, i ->
            res[index] = pref
            pref *= i
        }

        pref = 1

        for (i in nums.lastIndex downTo  0) {
            res[i] *= pref
            pref *= nums[i]
        }

        return res
    }
}

fun main() {
    ProductArrayExceptSelf().productExceptSelf(intArrayOf(1,2,3,4))
}