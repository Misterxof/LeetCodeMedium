package t_f_se_se_Minimum_Fuel_Cost_Report_Capital

import o_o_t_n_Shortest_Path_Alternating_Colors.ShortestPathAlternatingColors
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap

class MinimumFuelCostReportCapital {
    fun minimumFuelCost2(roads: Array<IntArray>, seats: Int): Long {
        val cities = hashMapOf<Int,  MutableList<Int>>()
        val first = hashMapOf<Int,  Int>()
        val visited = hashSetOf<Int>()
        var fuel = 0L
        var max = 0

        roads.forEach { (from, to) ->
        //    if (cities.containsKey(from))
//            if (from < to)
                cities.getOrPut(from) { mutableListOf() }.add(to)
                cities.getOrPut(to) { mutableListOf() }.add(from)
//            else cities.getOrPut(to) { mutableListOf() }.add(from)
            max = maxOf(max, from)
            max = maxOf(max, to)
        }

        val count = IntArray(max + 1){0}

        with(ArrayDeque<Int>()) {
            add(0)
            visited.add(0)
            count[0] = 0

            while (isNotEmpty()) {
                repeat(size) {
                    val node = removeFirst()
                    cities[node]?.let {
                        it.forEach {neighbor ->
                            if (!visited.contains(neighbor)) count[neighbor] = count[node] + 1
                            if (visited.add(neighbor)) add(neighbor)
                           // if (!cities.containsKey(neighbor)) fuel++
                           // println("n=$node neig=$neighbor")

                        }
                    }

                }
            }
        }

        count.forEachIndexed { i, it ->
            cities[i]?.let { nodeList ->
                if (nodeList.size > 1) count[i] = 0
                else {
                    val f = cities.values.stream().filter{it.size == 1 && it[0] == cities[i]!![0]}.count()
                    println("f=$f ${cities[i]}")
                    if (count[i] <= seats) fuel += count[i]
                    else {
                        val d = count[i] / seats
                        fuel += d + (count[i] - d) + (count[i] - seats)
                    }
                }
            }
        }

        println(cities)
        println(visited)
        println(count.joinToString())

        return fuel
    }

    val adj = Array<MutableList<Int>>(100001) { mutableListOf() }
    val size = IntArray(100001)
    fun minimumFuelCost(roads: Array<IntArray>, seats: Int): Long {
        var count = 0L

        for (i in roads) {
            adj[i[0]].add(i[1])
            adj[i[1]].add(i[0])
        }

        getSize(0, -1)
        for (i in 0 .. 100000) {
            if (size[i] > 0 && i != 0) {
                count += if (size[i] % seats == 0) {
                    size[i] / seats
                } else (size[i] / seats) + 1
            }
        }
        return count
    }

    fun getSize(curr: Int, prev: Int): Int {
        var total = 0
        for (i in adj[curr]) {
            if (i != prev) total += getSize(i, curr)
        }
        size[curr] = total + 1
        return size[curr]
    }
}

fun main() {
    println(MinimumFuelCostReportCapital().minimumFuelCost( arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(1,3),
            intArrayOf(1,4)),
            5))
    println()
    println(MinimumFuelCostReportCapital().minimumFuelCost( arrayOf(intArrayOf(3,1), intArrayOf(3,2), intArrayOf(1,0),
            intArrayOf(0,4), intArrayOf(0,5), intArrayOf(4,6)),
            2))
    println()
}