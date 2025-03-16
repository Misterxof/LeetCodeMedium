package t_fi_n_f_Minimum_Time_Repair_Cars

import kotlin.math.sqrt

class MinimumTimeRepairCars {
    fun repairCars(ranks: IntArray, cars: Int): Long {
        var min = 0L
        var max = ranks.min().toLong() * cars * cars

        while (min < max) {
            val middle = (max + min) / 2L

            if (isTimePossible(ranks, cars, middle)) max = middle
            else min = middle + 1

            println("mi $min ma $max md ${middle}")
        }

        return min
    }

    fun isTimePossible(ranks: IntArray, cars: Int, middle: Long): Boolean {
        var total = 0L

        ranks.forEach {
            total += sqrt((middle / it).toDouble()).toLong()
            println("t $total m $middle")
            if (total >= cars) return true
        }

        return false
    }
}

fun main() {
    println(MinimumTimeRepairCars().repairCars(intArrayOf(4,3,1,2), 10))
}