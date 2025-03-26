package t_o_th_th_Minimum_Operations_Make_Uni_Value_Grid

import java.util.TreeSet
import kotlin.math.abs

class MinimumOperationsMakeUniValueGrid {
    fun minOperations2(grid: Array<IntArray>, x: Int): Int {
        val list = mutableListOf<Int>()
        var result = 0

        grid.forEach {
            it.forEach { list.add(it) }
        }
        list.sort()

        val mid = list[list.size / 2]

        for (i in list.indices) {
            var cur = list[i]
            while (true) {
                if (cur == mid) break
                else if (cur < mid) {
                    result++
                    cur += x
                    if (cur > mid) return -1
                } else {
                    result++
                    cur -= x
                    if (cur < mid) return -1
                }
            }
        }

        return result
    }

    fun minOperations(grid: Array<IntArray>, x: Int): Int {
        val list = mutableListOf<Int>()
        var result = 0

        grid.forEach {
            it.forEach { list.add(it) }
        }
        list.sort()

        val mid = list[list.size / 2]

        for (i in list.indices) {
            if (list[i] % x != mid % x) return -1
            result += abs((mid - list[i]) / x)
        }

        return result
    }
}