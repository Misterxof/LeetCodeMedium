package t_fi_z_o_Longest_Square_Strel_Array

import java.util.TreeMap
import java.util.TreeSet

class LongestSquareStrelArray {
    fun longestSquareStreak(nums: IntArray): Int {
//        val res = mutableListOf<TreeSet<Int>>()
        var result = 0

        nums.forEach {
            val count = streak(nums, it, 1)

            result = if (count > result) count else result
        }

//        res.forEach {out ->
//            out.forEach { inner -> print("$inner, ") }
//            println()
//        }

        return if (result == 1) -1 else result
    }

    fun streak(nums: IntArray, num: Int, count: Int): Int {
        var res = count

        nums.forEach {
            if (it == (num * num)) {
                res = streak(nums, it, count + 1)
                return@forEach
            }
        }
        return res
    }
}

fun main() {
    println(LongestSquareStrelArray().longestSquareStreak(intArrayOf(4, 3, 6, 16, 8, 2)))
}