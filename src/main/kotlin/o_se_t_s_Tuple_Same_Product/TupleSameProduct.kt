package o_se_t_s_Tuple_Same_Product

class TupleSameProduct {
    fun tupleSameProduct(nums: IntArray): Int {
        val freq = HashMap<Int, Int>()
        var res = 0

        for (i in nums.indices) {
            for (j in i..nums.lastIndex) {
                if (i != j){
                    val mult = nums[i] * nums[j]
                    freq[mult] = freq.getOrPut(mult) { 0 } + 1
                }
            }
        }

        freq.forEach { k, v ->
            if (v > 1) {
                val pairs = ((v - 1) * v) / 2

                res += 8 * pairs
            }
        }

        return res
    }
}