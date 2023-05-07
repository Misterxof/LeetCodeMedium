package fi_f_Spiral_Matrix

import java.util.TreeSet

class SpiralMatrix {
    enum class Direction { LEFT, RIGHT, UP, BOTTOM }

    fun TreeSet<Pair<Int, Int>>.containPair(pair: Pair<Int ,Int>): Boolean {
        var result = false

        this.forEach {
            if (it.first == pair.first && it.second == pair.second) return true
        }

        return result
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var direction = if (matrix.size == 1 && matrix[0].size == 1) Direction.BOTTOM else Direction.RIGHT
        val result = mutableListOf<Int>()
        val coordinates = mutableListOf<Pair<Int, Int>>()
        var i = 0
        var j = 0

        while (true) {
            if (i < 0 || j < 0 || i > matrix.lastIndex || j > matrix[0].lastIndex || coordinates.contains(i to j)) break

            coordinates.add(i to j)
            result.add(matrix[i][j])

            when (direction) {
                Direction.RIGHT -> {
                    if ((i == 0 && j == matrix[0].lastIndex) ||
                        (j + 1 <= matrix[0].lastIndex && coordinates.contains(i to j + 1))
                    ) {
                        direction = Direction.BOTTOM
                        i++
                        continue
                    }
                    j++
                }

                Direction.BOTTOM -> {
                    if ((i == matrix.lastIndex && j == matrix[0].lastIndex) ||
                        (i + 1 <= matrix.lastIndex && coordinates.contains(i + 1 to j))
                    ) {
                        direction = Direction.LEFT
                        j--
                        continue
                    }
                    i++
                }

                Direction.LEFT -> {
                    if ((i == matrix.lastIndex && j == 0) ||
                        (coordinates.contains(i to j - 1))
                    ) {
                        direction = Direction.UP
                        i--
                        continue
                    }
                    j--
                }

                Direction.UP -> {
                    if (coordinates.contains(i - 1 to j)) {
                        direction = Direction.RIGHT
                        j++
                        continue
                    }
                    i--
                }
            }
        }

        return result
    }
}

fun main() {
    println(SpiralMatrix().spiralOrder(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
        )
    ).joinToString())
    println(
        SpiralMatrix().spiralOrder(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12),
                intArrayOf(13, 14, 15, 16),
            )
        ).joinToString()
    )
    println(
        SpiralMatrix().spiralOrder(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
            )
        ).joinToString()
    )
    println(
        SpiralMatrix().spiralOrder(
            arrayOf(
                intArrayOf(23,18,20,26,25),
                intArrayOf(24,22,3,4,4),
                intArrayOf(15,22,2,24,29),
                intArrayOf(18,15,23,28,28),
            )
        ).joinToString()
    )
}