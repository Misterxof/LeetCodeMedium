package f_s_Permutations

class Permutations {
    fun permute(nums: IntArray): List<List<Int>> {
        if (nums.size == 1) return listOf(listOf(nums[0]))
        val size = factorial(nums.size)
        val res = List(size) { MutableList(nums.size) { 0 } }
        val k = size / nums.size
        var index = 0

        for (i in nums.indices) {
            for (l in 0 until k) {
                res[index + l][0] = nums[i]
            }
            var ind = 1
            for (j in nums.indices) {
                if (nums[i] != nums[j]) {
                    println("in=$index $res j=$j ind=$ind")
                    for (l in 0 until k) {
                        if (ind + l <= k) res[index + l][ind + l] = nums[j]
                        else res[index + l][0 + l] = nums[j]
                    }
                    ind++
                    println("in=$index $res")

                }
            }
            index += k
        }

        println(res)
        return res
    }

    fun factorial(num: Int): Int {
        return if (num - 1 != 0) num * factorial(num - 1)
        else num
    }
}

fun main() {
    Permutations().permute(intArrayOf(1, 2, 3))
}