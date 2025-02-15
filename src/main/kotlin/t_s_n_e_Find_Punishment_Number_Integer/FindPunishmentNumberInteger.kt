package t_s_n_e_Find_Punishment_Number_Integer

class FindPunishmentNumberInteger {
    fun punishmentNumber(n: Int): Int {
        var result = 0
        var i = 1

        while (i <= n) {
            if (isPartition("${i * i}", i))
                result += i * i
            i++
        }

        return result
    }

    fun isPartition(num: String, target: Int): Boolean {
        if (target == 0 && num.isEmpty()) return true
        if (target < 0) return false

        for (i in num.indices) {
            val left = num.substring(0, i + 1)
            val right = num.substring(i + 1)

            if (isPartition(right, target - left.toInt()))
                return true
        }

        return false
    }
}