package o_o_s_t_As_Far_Land_Possible

import kotlin.math.abs

class AsFarLandPossible {
    fun maxDistance(grid: Array<IntArray>): Int {
        val hashMap = hashMapOf<Int, MutableList<Pair<Int, Int>>>()
        val distances = hashMapOf<String, MutableSet<Int>>()
        val minimals = mutableSetOf<Int>()
        var min = 10000

        grid.forEachIndexed { i, it ->
            it.forEachIndexed { j, jt ->
                if (hashMap.containsKey(jt))
                    hashMap[jt]!!.add(i to j)
                else
                    hashMap[jt] = mutableListOf(i to j)
            }
        }

        if (!hashMap.containsKey(0) || !hashMap.containsKey(1)) return -1

        println(hashMap)


        hashMap[0]!!.forEach {
            distances[it.toString()] = mutableSetOf()
            hashMap[1]!!.forEach { jt ->
                distances[it.toString()]!!.add(abs(it.first - jt.first) + abs(it.second - jt.second))

            }
        }

        distances.forEach {
            it.value.forEach {jt ->
                min = minOf(min, jt)
            }
            minimals.add(min)
            min = 10000
        }

        println(distances)

        return minimals.maxOf { it }
    }
}

fun main() {
    println(AsFarLandPossible().maxDistance(arrayOf(
            intArrayOf(1,0,1),
            intArrayOf(0,0,0),
            intArrayOf(1,0,1)
    )))
    println()
    println(AsFarLandPossible().maxDistance(arrayOf(
            intArrayOf(1,0,0),
            intArrayOf(0,0,0),
            intArrayOf(0,0,0)
    )))
    println()
    println(AsFarLandPossible().maxDistance(arrayOf(
            intArrayOf(0,0,1,1,1),
            intArrayOf(0,1,1,0,0),
            intArrayOf(0,0,1,1,0),
            intArrayOf(1,0,0,0,0),
            intArrayOf(1,1,0,0,1)
    )))
}