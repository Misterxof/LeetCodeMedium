package t_o_se_Contains_Duplicate

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var sum = Int.MIN_VALUE

        nums.forEachIndexed {index, i ->
            for (j in index..(nums.size)){
                var sumT = 0
                if (index != j){
                    sumT = nums.copyOfRange(index, j).sum() // 1..collection.size, 0 0 returns nothing

                    if (sumT > sum)
                        sum = sumT
                }


                println("i=$index j=$j sumT=$sumT sum=$sum")
            }
        }

        return sum
    }
}