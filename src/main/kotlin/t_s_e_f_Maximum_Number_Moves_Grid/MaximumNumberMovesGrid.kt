package t_s_e_f_Maximum_Number_Moves_Grid

import kotlin.math.max

class MaximumNumberMovesGrid {
    lateinit var table: Array<BooleanArray>
    var max = 0
    fun maxMoves(grid: Array<IntArray>): Int {
        table = Array<BooleanArray>(grid.size) { BooleanArray(grid[0].size) }

        grid.forEachIndexed { index, ints ->
            table[index][0] = true
            ints.forEachIndexed { index2, i ->  moves(grid, index, index2, 0) }
        }

        table.forEachIndexed { index, ints ->
            ints.forEach { print("$it ") }
            println()
        }
        return max
    }

    fun moves(grid: Array<IntArray>, row: Int, column: Int, path: Int): Int {
        var res = path

        if (row + 1 <= grid.size - 1 && column + 1 <= grid[row + 1].size - 1 &&
            grid[row + 1][column + 1] > grid[row][column] && table[row][column] != false) {
            table[row+1][column+1] = true
            if (max < column+1) max = column+1
        }
        if (column + 1 <= grid[row].size - 1 && grid[row][column + 1] > grid[row][column] && table[row][column] != false) {
            table[row][column+1] = true
            if (max < column+1) max = column+1
        }
        if (row - 1 >= 0 && column + 1 <= grid[row - 1].size - 1 &&
            grid[row - 1][column + 1] > grid[row][column] && table[row][column] != false) {
            table[row-1][column+1] = true
            if (max < column+1) max = column+1
        }

        return res
    }
}

fun main() {
    println(MaximumNumberMovesGrid().maxMoves(arrayOf(intArrayOf(2,4,7,8),
        intArrayOf(5,4,9,3), intArrayOf(3,4,2,11), intArrayOf(10,9,13,15)
    )))
//    println(MaximumNumberMovesGrid().maxMoves(arrayOf(intArrayOf(3,2,4),
//        intArrayOf(2,1,9 ), intArrayOf(1,1,7)
//    )))
}