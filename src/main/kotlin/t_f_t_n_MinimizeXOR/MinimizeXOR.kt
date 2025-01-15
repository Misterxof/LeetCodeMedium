package t_f_t_n_MinimizeXOR

class MinimizeXOR {
    private fun Int.isSet(i: Int): Boolean = (this and (1 shl i)) > 0
    private fun Int.setBit(i: Int): Int = this or (1 shl i)

    fun minimizeXor(num1: Int, num2: Int): Int {
        var result = 0
        val targetCount = num2.countOneBits()
        var setBitsCount = 0
        var currentBit = 31

        while(setBitsCount < targetCount) {
            if (num1.isSet(currentBit) ||
                (targetCount - setBitsCount > currentBit)) {
                result = result.setBit(currentBit)
                setBitsCount++
            }
            currentBit--
        }

        return result
    }
}