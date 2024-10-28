package t_fi_z_o_Longest_Square_Strel_Array

import java.util.TreeMap
import java.util.TreeSet
import kotlin.math.sqrt

class LongestSquareStrelArray {
    fun longestSquareStreak(nums: IntArray): Int {
        val res = TreeSet<Int>()
        var max = -1
        
        nums.forEach { res.add(it) }

        res.forEach {
            var count = 1
            var num = it
            while (true) {
                if (res.contains(num * num) && (num * num) > num) {
                    count++
                    num *= num
                } else break
            }
            if (max < count) max = count
        }

        return if (max == 1) -1 else max
    }
}

fun main() {
    println(LongestSquareStrelArray().longestSquareStreak(intArrayOf(4, 3, 6, 16, 8, 2)))
    println(LongestSquareStrelArray().longestSquareStreak(intArrayOf(4,16,256,65536)))
}