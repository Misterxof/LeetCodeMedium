package t_t_t_s_Maximum_Candies_Allocated_Children

class MaximumCandiesAllocatedChildren {
    fun maximumCandies(candies: IntArray, k: Long): Int {
        if (!isEnoughCandies(candies, k, 1)) return 0
        var left = 1L
        var right = candies.max().toLong()
        var middle = 0L

        while (left <= right) {
            middle = left + (right - left) / 2L

            if (isEnoughCandies(candies, k, middle)) left = middle + 1
            else right = middle - 1
        }
        println("l = $left r = $right m = $middle")
        return left.toInt()
    }

    fun isEnoughCandies(candies: IntArray, k: Long, middle: Long): Boolean {
        var count = 0L

        for (i in candies.indices) {
            count += candies[i] / middle

            if (count >= k) return true
        }

        return false
    }
}