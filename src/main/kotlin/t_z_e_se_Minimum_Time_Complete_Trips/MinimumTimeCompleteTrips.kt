package t_z_e_se_Minimum_Time_Complete_Trips

class MinimumTimeCompleteTrips {

    fun minimumTime(time: IntArray, totalTrips: Int): Long {
        var res = Long.MAX_VALUE
        var middle: Long
        var left = time.min().toLong()
        var right = (totalTrips.toLong() / time.size + 1) * time.max().toLong()

        while (left <= right) {
            var curTT = 0L

            middle = (left + right) / 2

            for (i in time.indices)
                curTT += (middle / time[i])

            if (curTT < totalTrips.toLong()) left = middle + 1
            else {
                res = minOf(res, middle)
                right = middle - 1
            }
        }
        return res
    }
}

fun main() {
    println(MinimumTimeCompleteTrips().minimumTime(intArrayOf(1,2,3), 5))
    println(MinimumTimeCompleteTrips().minimumTime(intArrayOf(3,3,8), 6))
    println(MinimumTimeCompleteTrips().minimumTime(intArrayOf(9,7,10,9,10,9,10), 1))
    println(MinimumTimeCompleteTrips().minimumTime(intArrayOf(10,7,4,2), 7))
}