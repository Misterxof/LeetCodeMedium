package e_se_fi_Koko_Eating_Bananas

class KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var middle: Int
        var left = 1
        var right = piles.max()

        var bananasAmount = Int.MAX_VALUE

        while(left <= right) {
            middle = (left + right) / 2

            if (isEnough(piles.clone(), h, middle)) {
                bananasAmount = minOf(bananasAmount, middle)
                right = middle - 1
            } else left = middle + 1
        }

        return bananasAmount
    }

    private fun isEnough(piles: IntArray, h: Int, bananasAmount: Int) : Boolean {
        var currentHour = 0
        var i = 0

        while (currentHour <= h && i <= piles.lastIndex) {
            if (piles[i] < bananasAmount) currentHour++
            else currentHour += if (piles[i] % bananasAmount != 0) piles[i] / bananasAmount + 1 else piles[i] / bananasAmount

            i++
        }

        return currentHour <= h
    }
}

fun main() {
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(3,6,7,11), 8))
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(30,11,23,4,20), 5))
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(312884470), 312884469))
    println(KokoEatingBananas().minEatingSpeed(intArrayOf(1000000000), 2))
}