package t_fi_t_th_Closest_Prime_Numbers_Range

import kotlin.math.sqrt

class ClosestPrimeNumbersRange {
    fun closestPrimes(left: Int, right: Int): IntArray {
        val map = HashMap<Int, IntArray>()
        var first = -1
        var min = Int.MAX_VALUE

        for (i in left..right) {
            if (isPrime(i)){
                if (first == -1) first = i
                else {
                    //  if we have same difference - first val must be the lowest => first one
                    if (!map.containsKey(i - first))
                        map[i - first] = intArrayOf(first, i)
                    first = i
                }
            }
        }

        //  no pairs
        if (map.size == 0) return intArrayOf(-1, -1)

        map.forEach { min = minOf(min, it.key) }

        return map[min]!!
    }

    fun isPrime(number: Int): Boolean {
        if (number < 2) return false
        if (number == 2) return true
        if (number % 2 == 0) return false

        for (i in 3..sqrt(number.toDouble()).toInt() step 2) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}