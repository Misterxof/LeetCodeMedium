package o_o_t_n_Shortest_Path_Alternating_Colors

class ShortestPathAlternatingColors {
    fun shortestAlternatingPaths2(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
        var allNodesHM = hashMapOf<Pair<Int, Int>, Int>()
        val used = BooleanArray(n){false}
        val sums = IntArray(n){0}
        val paths = IntArray(n-1){0}
        val queue = ArrayDeque<Int>()

        redEdges.forEach { allNodesHM[it[0] to it[1]] = 0 }
        blueEdges.forEach { allNodesHM[it[0] to it[1]] = 1 }

         allNodesHM = allNodesHM.toSortedMap(compareBy ({ it.first }, {it.second})).toMap() as HashMap<Pair<Int, Int>, Int>

        println(allNodesHM)

        queue.add(0)
        used[0] = true
        sums[0] = 0

        while (queue.isNotEmpty()) {
            var cur = queue.removeFirst()
            val t = cloneHM(allNodesHM)

            allNodesHM.forEach {
                if (it.key.first == cur && !used[it.key.second]) {
                    used[it.key.second] = true
                    sums[it.key.second] = sums[cur] + 1
                    paths[it.key.second - 1] = it.value
                    queue.add(it.key.second)
                    t.remove(it.key)
                }
            }

            allNodesHM = t
//            println(allNodesHM)
        }

        println(sums.joinToString())
        println(paths.joinToString())
        for (i in 1 until sums.size) {
            if (!used[i]) sums[i] = -1
            var prevL = -1
            for (j in 0 until i) {
                if (i == 1) {
                    break
                }
//                println("i=$i j=$j")
                val curL = paths[j]
                if (prevL != -1){
                    if (prevL != curL) {
                        prevL = curL
                        continue
                    } else {
                        sums[i] = -1
                        break
                    }
                } else {
                    prevL = curL
                }
            }
        }

        println(used.joinToString())
        println(sums.joinToString())
//        println(paths.joinToString())

        return intArrayOf()
    }

    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
        val edgesRed = mutableMapOf<Int, MutableList<Int>>()
        val edgesBlue = mutableMapOf<Int, MutableList<Int>>()
        val res = IntArray(n) { -1 }
        val visited = hashSetOf<Pair<Int, Boolean>>()
        var dist = 0

        redEdges.forEach { (from, to) ->
            edgesRed.getOrPut(from) { mutableListOf() }.add(to)
        }

        blueEdges.forEach { (from, to) ->
            edgesBlue.getOrPut(from) { mutableListOf() }.add(to)
        }

        with(ArrayDeque<Pair<Int, Boolean>>()) {
            add(0 to true)
            add(0 to false)
            visited.add(0 to true)
            visited.add(0 to false)

            while (isNotEmpty()) {
                repeat(size) {
                    val (node, isRed) = removeFirst()
                    if (res[node] == -1 || res[node] > dist) res[node] = dist
                    val edges = if (isRed) edgesRed else edgesBlue
                    edges[node]?.forEach {
                        if (visited.add(it to !isRed)) add(it to !isRed)
                    }
                }
                dist++
            }
        }

        return res
    }

    fun cloneHM(hashMap: HashMap<Pair<Int, Int>, Int>): HashMap<Pair<Int, Int>, Int> {
        val t = hashMapOf<Pair<Int, Int>, Int>()

        hashMap.forEach { t[it.key] = it.value }
        return t
    }
}

fun main() {
    println(ShortestPathAlternatingColors().shortestAlternatingPaths(3, arrayOf(intArrayOf(0,1), intArrayOf(1,2)),
            arrayOf()).joinToString())
    println()
    ShortestPathAlternatingColors().shortestAlternatingPaths(3, arrayOf(intArrayOf(0,1)),
            arrayOf(intArrayOf(2, 1)))
    println()
    ShortestPathAlternatingColors().shortestAlternatingPaths(3, arrayOf(intArrayOf(1,0)),
            arrayOf(intArrayOf(2, 1)))
}