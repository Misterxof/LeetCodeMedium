package th_t_z_e_Alternating_GroupsII

class AlternatingGroupsII {
    fun numberOfAlternatingGroups(colors: IntArray, k: Int): Int {
        val circle = IntArray(colors.size + k - 1)
        val length = circle.size
        var right = 1
        var left = 0
        var result = 0

        for (i in colors.indices)
            circle[i] = colors[i]

        for (i in 0 until k)
            circle[colors.size + i] = colors[i]

        while (right < length) {
            if (circle[right] == circle[right - 1]) {
                left = right++
                continue
            }

            right++

            if (right - left < k) continue

            result++
            left++
        }

        return result
    }
}