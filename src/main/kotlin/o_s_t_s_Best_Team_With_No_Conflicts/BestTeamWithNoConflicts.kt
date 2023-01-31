package o_s_t_s_Best_Team_With_No_Conflicts

class BestTeamWithNoConflicts {
    fun bestTeamScore(scores: IntArray, ages: IntArray): Int {
        val list = ages.zip(scores).sortedWith(compareBy({ it.first }, { it.second }))
        val sumsList = IntArray(list.size)
        var maxSum = Int.MIN_VALUE

        list.forEachIndexed { index, pair ->
            val currentScore = pair.second
            sumsList[index] = currentScore

            for (j in 0 until index) {
                if (list[j].second <= currentScore) {
                    sumsList[index] = maxOf(sumsList[index], sumsList[j] + currentScore)
                }
            }

            maxSum = maxOf(maxSum, sumsList[index])
        }
        return maxSum
    }
}
fun main(args: Array<String>) {
    println(BestTeamWithNoConflicts().bestTeamScore(intArrayOf(1,3,5,10,15), intArrayOf(1,2,3,4,5)))
    println(BestTeamWithNoConflicts().bestTeamScore(intArrayOf(4,5,6,5), intArrayOf(2,1,2,1)))
    println(BestTeamWithNoConflicts().bestTeamScore(intArrayOf(1,2,3,5), intArrayOf(8,9,10,1)))
}