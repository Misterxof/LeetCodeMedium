package f_n_e_Diagonal_Traverse

import kotlin.math.abs

class DiagonalTraverse {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val result = IntArray(mat.size * mat[0].size)
        var putIndex = 0
        var isUp = true
        var i = 0
        var j = 0

        //diagonalReader(mat, 0, 0, true, result)
        while (i != mat.lastIndex || j != mat[0].lastIndex) {
            result[putIndex++] = mat[i][j]

            if (isUp) {
                when {
                    i == 0 -> {
                        if (j < mat[0].lastIndex) {
                            j++
                            isUp = false
                            continue
                        } else {
                            i++
                            isUp = false
                            continue
                        }
                    }

                    j == mat[0].lastIndex && i + 1 <= mat.lastIndex -> {
                        i++
                        isUp = false
                        continue
                    }
                }
            } else {
                when {
                    j == 0 -> {
                        if (i < mat.lastIndex) {
                            i++
                            isUp = true
                            continue
                        } else {
                            j++
                            isUp = true
                            continue
                        }
                    }

                    i == mat.lastIndex && j + 1 <= mat[0].lastIndex -> {
                        j++
                        isUp = true
                        continue
                    }
                }
            }

            if (isUp) {
                i--
                j++
            } else {
                i++
                j--
            }
        }
        result[putIndex++] = mat[i][j]

        return result
    }

    fun diagonalReader(
        mat: Array<IntArray>,
        i: Int,
        j: Int,
        isUp: Boolean,
        result: ArrayList<Int>
    ) {
        if (i > mat.lastIndex || j > mat[0].lastIndex || j < 0 || i < 0) return

        result.add(mat[i][j])

        if (isUp) {
            when {
                i == 0 -> {
                    if (j < mat[0].lastIndex) {
                        diagonalReader(mat, i, j + 1, false, result)
                    } else {
                        diagonalReader(mat, i + 1, j, false, result)
                    }
                }

                j == mat[0].lastIndex && i + 1 <= mat.lastIndex -> {
                    diagonalReader(mat, i + 1, j, false, result)
                }
            }
        } else {
            when {
                j == 0 -> {
                    if (i < mat.lastIndex) {
                        diagonalReader(mat, i + 1, j, true, result)
                    } else {
                        diagonalReader(mat, i, j + 1, true, result)
                    }
                }

                i == mat.lastIndex && j + 1 <= mat[0].lastIndex -> {
                    diagonalReader(mat, i, j + 1, true, result)
                }
            }
        }

        if (isUp) diagonalReader(mat, i - 1, j + 1, true, result)
        else diagonalReader(mat, i + 1, j - 1, false, result)
    }
}

fun main() {
    println(
        DiagonalTraverse().findDiagonalOrder(
            arrayOf(
                intArrayOf(1, 2, 3),
                intArrayOf(4, 5, 6),
                intArrayOf(7, 8, 9),
            )
        ).joinToString()
    )
    println(
        DiagonalTraverse().findDiagonalOrder(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12),
                intArrayOf(13, 14, 15, 16),
            )
        ).joinToString()
    )
    println(
        DiagonalTraverse().findDiagonalOrder(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
            )
        ).joinToString()
    )
}