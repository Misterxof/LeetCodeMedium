package o_fi_t_f_Number_SubArray_With_Odd_Sum

class NumberSubArrayWithOddSum {
    fun numOfSubarrays(arr: IntArray): Int {
        var count = 0L
        var oddCount = 0L
        var evenCount = 0L

        for (n in arr) {
            if (n % 2 == 0) evenCount++
            else evenCount = oddCount.also { oddCount = evenCount + 1 }

            count += oddCount
        }

        return (count % (1e9 + 7)).toInt()
    }
}