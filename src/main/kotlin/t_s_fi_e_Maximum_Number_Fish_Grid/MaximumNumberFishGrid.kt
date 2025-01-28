package t_s_fi_e_Maximum_Number_Fish_Grid

class MaximumNumberFishGrid {
    fun findMaxFish(grid: Array<IntArray>): Int {
        var max = Int.MIN_VALUE
        val visited = Array(grid.size) { BooleanArray(grid[0].size) }

        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] > 0 && !visited[row][col]) {
                    max = maxOf(
                        max,
                        calculateFishes(grid, visited, row, col)
                    )
                }
            }
        }

        return max
    }

    fun calculateFishes(grid: Array<IntArray>, visited: Array<BooleanArray>, row: Int, col: Int): Int {
        if (row < 0 || row >= grid.size || col < 0 || col >= grid[0].size ||
            grid[row][col] == 0 || visited[row][col]
        )
            return 0

        visited[row][col] = true

        return grid[row][col] + calculateFishes(grid, visited, row, col + 1) +
                calculateFishes(grid, visited, row, col - 1) +
                calculateFishes(grid, visited, row + 1, col) +
                calculateFishes(grid, visited, row - 1, col)
    }
}