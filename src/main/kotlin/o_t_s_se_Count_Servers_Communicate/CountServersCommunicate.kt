package o_t_s_se_Count_Servers_Communicate

class CountServersCommunicate {
    fun countServers(grid: Array<IntArray>): Int {
        var rowCounts = IntArray(grid.size)
        var colCounts = IntArray(grid[0].size)
        var result = 0

        for (row in grid.indices) {
            for (col in grid[0].indices){
                if (grid[row][col] == 1) {
                    rowCounts[row]++
                    colCounts[col]++
                }
            }
        }

        for (row in grid.indices) {
            for (col in grid[0].indices) {
                if (grid[row][col] == 1) {
                    if (rowCounts[row] > 1 || colCounts[col] > 1)
                        result++
                }
            }
        }

        return result
    }
}