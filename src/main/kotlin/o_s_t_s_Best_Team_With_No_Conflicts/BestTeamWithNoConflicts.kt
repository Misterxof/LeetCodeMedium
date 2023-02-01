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

    fun bestTeamScore2(scores: IntArray, ages: IntArray): Int {
        val list = ages.zip(scores).sortedWith(compareBy({ it.first }, { it.second }))
        val sumsList = IntArray(list.size)
        val sumsList2 = IntArray(list.size)
        var yc = list[0].second
        var oc = list[list.size-1].second

        println(list)

        list.forEachIndexed { i, pair ->
            for (j in 0 until i+1) {
                if (pair.first <= list[j].first && pair.second <= list[j].second) {  // младше и <= очков
                    sumsList[i] += list[j].second
                   // println("i=${pair} j=${list[j]} sum=${sumsList[i]}")
                }

                if (pair.first >= list[j].first && pair.second >= list[j].second ) {
                    sumsList2[i] += list[j].second
                }
            }
        }

        println(sumsList.joinToString())
        println(sumsList2.joinToString())
        return maxOf(sumsList.max(), sumsList2.max())
    }
}
fun main(args: Array<String>) {
//    println(BestTeamWithNoConflicts().bestTeamScore(intArrayOf(1,3,5,10,15), intArrayOf(1,2,3,4,5)))
//    println(BestTeamWithNoConflicts().bestTeamScore(intArrayOf(4,5,6,5), intArrayOf(2,1,2,1)))
    println(BestTeamWithNoConflicts().bestTeamScore(intArrayOf(1,2,3,5), intArrayOf(8,9,10,1)))
//    println(BestTeamWithNoConflicts().bestTeamScore(intArrayOf(9,2,8,8,2), intArrayOf(4,1,3,3,5)))
}