package t_s_e_f_Maximum_Number_Moves_Grid

import kotlin.math.max

class MaximumNumberMovesGrid {
    fun maxMoves(grid: Array<IntArray>): Int {
        var max = 0

        grid.forEachIndexed { index, ints ->
            val path = moves(grid, index, 0, 0)
            if (max < path) max = path
        }

        return max
    }

    fun moves(grid: Array<IntArray>, row: Int, column: Int, path: Int): Int {
        var res = path

        if (row + 1 <= grid.size - 1 && column + 1 <= grid[row + 1].size - 1 &&
            grid[row + 1][column + 1] > grid[row][column]) {
            res = max(res, moves(grid, row + 1, column + 1, path + 1))
        }
        if (column + 1 <= grid[row].size - 1 && grid[row][column + 1] > grid[row][column]) {
            res = max(res, moves(grid, row, column + 1, path + 1))
        }
        if (row - 1 >= 0 && column + 1 <= grid[row - 1].size - 1 &&
            grid[row - 1][column + 1] > grid[row][column]) {
            res = max(res, moves(grid, row - 1, column + 1, path + 1))
        }

        return res
    }
}

fun main() {
    println(MaximumNumberMovesGrid().maxMoves(arrayOf(intArrayOf(2,4,7,8),
        intArrayOf(5,4,9,3), intArrayOf(3,4,2,11), intArrayOf(10,9,13,15)
    )))
}