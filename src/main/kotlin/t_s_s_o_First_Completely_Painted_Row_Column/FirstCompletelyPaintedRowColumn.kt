package t_s_s_o_First_Completely_Painted_Row_Column

class FirstCompletelyPaintedRowColumn {
    fun firstCompleteIndex2(arr: IntArray, mat: Array<IntArray>): Int {
        val lotteryArray = IntArray(mat.size + mat[0].size)

        lotteryArray.forEachIndexed { i, v ->
            if (i < mat.size) lotteryArray[i] = mat[0].size
            else lotteryArray[i] = mat.size
        }

        outer@ for (x in arr.indices) {
            lotteryArray.forEach { print("$it, ") }
            println()
            for (i in mat.indices) {
                for (j in mat[0].indices) {
                    if (mat[i][j] == arr[x]) {
                        lotteryArray[i] -= 1
                        lotteryArray[j + mat.size] -= 1
                        println("$x ${arr[x]} r $i ${lotteryArray[i]} c $j ${lotteryArray[i + j + 1]}")
                        println()

                        if (lotteryArray[i] == 0 || lotteryArray[j + mat.size] == 0) return x
                        else continue@outer
                    }
                }
            }
        }

        return -1
    }

    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val matrixHashMap = HashMap<Int, Pair<Int, Int>>()
        val rows = IntArray(mat.size){ mat[0].size }
        val columns = IntArray(mat[0].size){ mat.size }

        for (i in mat.indices) {
            for (j in mat[0].indices) {
                matrixHashMap[mat[i][j]] = i to j
            }
        }

        for (i in arr.indices) {
            val matrixElement = matrixHashMap[arr[i]]

            rows[matrixElement!!.first] -= 1
            columns[matrixElement!!.second] -= 1

            if (rows[matrixElement!!.first] == 0 || columns[matrixElement!!.second] == 0)
                return i
        }

        return -1
    }
}

fun main() {
//    println(FirstCompletelyPaintedRowColumn().firstCompleteIndex(intArrayOf(1,3,4,2), arrayOf(
//        intArrayOf(1,4),
//        intArrayOf(2,3)
//    )))
    println(
        FirstCompletelyPaintedRowColumn().firstCompleteIndex(
            intArrayOf(6, 2, 3, 1, 4, 5), arrayOf(
                intArrayOf(5, 1),
                intArrayOf(2, 4),
                intArrayOf(6, 3),
            )
        )
    )
//    println(FirstCompletelyPaintedRowColumn().firstCompleteIndex(intArrayOf(2,8,7,4,1,3,5,6,9), arrayOf(
//        intArrayOf(3,2,5),
//        intArrayOf(1,4,6),
//        intArrayOf(8,7,9)
//    )))
}