package th_o_s_z_Find_Number_Distinct_Colors_Among_Balls

class FindNumberDistinctColorsAmongBalls {
    fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
        val balls = HashMap<Int, Int>()
        val colors = HashMap<Int, Int>()
        val result = IntArray(queries.size)

        for (i in queries.indices) {
            if (balls.containsKey(queries[i][0])) {
                val prev = balls[queries[i][0]]!!
                colors[prev] = colors[prev]!! - 1

                if (colors[prev] == 0) colors.remove(prev)
            }
            colors[queries[i][1]] = colors.getOrPut(queries[i][1]) { 0 } + 1
            balls[queries[i][0]] = queries[i][1]

            result[i] = colors.size
        }

        return result
    }
}