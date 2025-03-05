package t_fi_se_n_Count_Total_Number_Colored_Cells

class CountTotalNumberColoredCells {
    fun coloredCells(n: Int): Long {
        var multi = n - 1
        var result = 0L

        while (multi != 0) {
            result += multi * 4
            multi--
        }

        return result + 1
    }
}