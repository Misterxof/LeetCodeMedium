package o_t_z_Triangle

import kotlin.math.min
import kotlin.math.pow

class Triangle {
    fun minimumTotal(triangle: List<MutableList<Int>>): Int {
        if (triangle.lastIndex != 0) triangleToMinimum(triangle, triangle.lastIndex)

        return triangle[0][0]
    }

    private fun triangleToMinimum(triangle: List<MutableList<Int>>, index: Int) {
        for (i in triangle[index - 1].indices)
            triangle[index - 1][i] += minOf(triangle[index][i], triangle[index][i + 1 ])
        if (index - 1 != 0) triangleToMinimum(triangle, index - 1)
    }
}

fun main() {
    println(Triangle().minimumTotal(listOf(
            mutableListOf(2),
            mutableListOf(3,4),
            mutableListOf(6,5,7),
            mutableListOf(4,1,8,3)
    )))
    println(Triangle().minimumTotal(listOf(
            mutableListOf(-1),
            mutableListOf(2,3),
            mutableListOf(1,-1,-3)
    )))
}