package o_z_o_o_Capacity_Ship_Packages_Within_Days

class CapacityShipPackagesWithinDays {
    fun shipWithinDays2(weights: IntArray, days: Int): Int {
        var weight = weights.max()

        while (true) {
            var curWeightLimit = 0
            var curDays = days
            var end = 0
           // println(weight)

            for (i in weights.indices) {
                if (i <= weights.lastIndex && curDays != 0) {
                    if (curWeightLimit + weights[i] <= weight) {
                        curWeightLimit += weights[i]
                      //  println("i=$i a=${weights[i]} w=$curWeightLimit d=$curDays")
                    } else {
                        if (weights[i] <= weight && curDays != 1) {
                            curWeightLimit = weights[i]
                            curDays--
                          //  println("i=$i a=${weights[i]} w=$curWeightLimit d=$curDays")
                        }
                        else {
                            weight++
                            break
                        }
                    }
                } else {
                    weight++
                    break
                }
                end = i
            }
            if (end == weights.lastIndex) return weight
        }
    }

    // faster
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var left = weights.max()
        var right = weights.sum()

        fun checkWeight(weight: Int): Boolean {
            var curWeightLimit = 0
            var curDays = days

            for (i in weights.indices) {
                curWeightLimit += weights[i]
                if (curWeightLimit > weight) {
                    curWeightLimit = weights[i]
                    curDays--
                }
            }
            if (curWeightLimit > weight) curDays--
            return curDays >= 1
        }

        var min = right

        while (left <= right) {
            val middle = (left + right) / 2
            val check = checkWeight(middle)

            if (check) {
                min = minOf(min, middle)
                right = middle - 1
            } else left = middle + 1
        }
        return min
    }


}

fun main() {
    println(CapacityShipPackagesWithinDays().shipWithinDays(intArrayOf(1,2,3,4,5,6,7,8,9,10), 5))
    println(CapacityShipPackagesWithinDays().shipWithinDays(intArrayOf(3,2,2,4,1,4), 3))
    println(CapacityShipPackagesWithinDays().shipWithinDays(intArrayOf(1,2,3,1,1), 4))
}