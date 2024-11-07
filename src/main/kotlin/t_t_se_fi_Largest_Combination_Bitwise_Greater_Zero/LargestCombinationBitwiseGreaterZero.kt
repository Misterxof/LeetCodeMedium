package t_t_se_fi_Largest_Combination_Bitwise_Greater_Zero

class LargestCombinationBitwiseGreaterZero {
    fun largestCombination(candidates: IntArray): Int {
        var max = 0

        for(i in 0..31) {
            var count = 0

            candidates.forEach {
                if((it and (1 shl i)) != 0) count++
            }

            max = maxOf(max, count)
        }

        return max
    }
}