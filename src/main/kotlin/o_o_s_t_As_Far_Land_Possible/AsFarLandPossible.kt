package o_o_s_t_As_Far_Land_Possible

import java.util.Arrays.copyOf
import kotlin.math.abs

class AsFarLandPossible {
    var distance = 0

    fun maxDistance(grid: Array<IntArray>): Int {
        if (!containsWater(grid) || !containsLand(grid)) return -1
        var result = Array(grid.size) { IntArray(grid[0].size) }
        var grid = grid

        do {
            grid.forEachIndexed { i, it ->
                it.forEachIndexed { j, jt ->
                    if (jt == 1) {
                        result[i][j] = 1
                        if (j - 1 >= 0)
                            result[i][j - 1] = 1
                        if (j + 1 <= it.size - 1)
                            result[i][j + 1] = 1
                        if (i - 1 >= 0)
                            result[i - 1][j] = 1
                        if (i + 1 <= grid.size - 1)
                            result[i + 1][j] = 1
                    }
                }
            }
            grid = result
            result = cloneArray(grid)
            distance++
        } while (containsWater(result))

        return distance
    }

    private fun cloneArray(grid: Array<IntArray>): Array<IntArray> {
        val result = Array(grid.size) { IntArray(grid[0].size) }

        grid.forEachIndexed { i, it ->
            it.forEachIndexed { j, jt ->
                result[i][j] = jt
            }
        }

        return result
    }

    private fun containsWater(grid: Array<IntArray>): Boolean {
        grid.forEach {
            if (it.contains(0)) return true
        }

        return false
    }

    private fun containsLand(grid: Array<IntArray>): Boolean {
        grid.forEach {
            if (it.contains(1)) return true
        }

        return false
    }
}

fun main() {
    println(AsFarLandPossible().maxDistance(arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1)
    )))
    println()
    println(AsFarLandPossible().maxDistance(arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
    )))
    println()
    println(AsFarLandPossible().maxDistance(arrayOf(
            intArrayOf(0, 0, 1, 1, 1),
            intArrayOf(0, 1, 1, 0, 0),
            intArrayOf(0, 0, 1, 1, 0),
            intArrayOf(1, 0, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 1)
    )))
}