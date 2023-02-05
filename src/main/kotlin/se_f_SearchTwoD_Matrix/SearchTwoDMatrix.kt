package se_f_SearchTwoD_Matrix

class SearchTwoDMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var left = 0
        var right = matrix.size - 1
        var middle = 0

        // find array that possibly contains target
        while (left <= right) {
            middle = (left + right) / 2

            if (target == matrix[middle][0] || target == matrix[middle][matrix[middle].size - 1]) break

            if (matrix[middle][0] < target && target < matrix[middle][matrix[middle].size - 1]) break

            if (target > matrix[middle][0] && target > matrix[middle][matrix[middle].size - 1])
                left = middle + 1
            else
                right = middle - 1
        }

        left = 0
        right = matrix[middle].size - 1
        var middleRow = 0

        // find target
        while (left <= right) {
            middleRow = (left + right) / 2

            if (target == matrix[middle][middleRow]) return true

            if (target > matrix[middle][middleRow])
                left = middleRow + 1
            else
                right = middleRow - 1
        }

        return false
    }
}

fun main() {
    println(SearchTwoDMatrix().searchMatrix(arrayOf(
        intArrayOf(1,3,5,7),
        intArrayOf(10,11,16,20),
        intArrayOf(23,30,34,60)
    ), 3))
    println(SearchTwoDMatrix().searchMatrix(arrayOf(
        intArrayOf(1,3,5,7),
        intArrayOf(10,11,16,20),
        intArrayOf(23,30,34,60)
    ), 13))
    println(SearchTwoDMatrix().searchMatrix(arrayOf(
        intArrayOf(1,3,5,7),
        intArrayOf(10,11,16,20),
        intArrayOf(23,30,34,50)
    ), 11))
    println(SearchTwoDMatrix().searchMatrix(arrayOf(
        intArrayOf(1),
        intArrayOf(3)
    ), 3))
}