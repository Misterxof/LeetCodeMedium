package t_z_o_se_Grid_Game

import kotlin.math.min

class GridGame {
    fun gridGame(grid: Array<IntArray>): Long {
        var firstSum = 0L
        var secondSum = 0L
        var min = Long.MAX_VALUE

        grid[0].forEach { firstSum += it }

        for (i in grid[0].indices) {
            firstSum -= grid[0][i]
            min = min(
                min,
                maxOf(firstSum, secondSum)
            )
            secondSum += grid[1][i]
        }

        return min
    }
}