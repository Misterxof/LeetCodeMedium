package s_e_f_Redundant_Connection

class RedundantConnection {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val map = HashMap<Int, MutableList<Int>>()

        for (i in edges.indices) {
            map.computeIfAbsent(i, { k -> mutableListOf() })
        }

        map.forEach { k, v ->
            println("$k -> ${v.toString()}")
        }

        for (i in edges.indices) {
            val visited = BooleanArray(edges.size)

            if (isCycle(map, visited, edges[i][0] - 1, edges[i][1] - 1)) {
                println("${edges[i][0]} -> ${edges[i][1]}")
                return intArrayOf(edges[i][0], edges[i][1])
            }

            map[edges[i][0] - 1]!!.add(edges[i][1] - 1)
            map[edges[i][1] - 1]!!.add(edges[i][0] - 1)
        }

        return intArrayOf()
    }

    fun isCycle(map: HashMap<Int, MutableList<Int>>, visited: BooleanArray, cur: Int, target: Int): Boolean {
        val list = map[cur]
        var res = false
        visited[cur] = true
        if (cur == target) return true

        list?.let {
            for (i in list.indices) {
                println("k = $cur next = ${list[i]} res = $res")
                if (!visited[list[i]])
                    res = res || isCycle(map, visited, list[i], target)
            }
        }

        return res
    }

    class Node(val node: Int) {
        var next: Node? = null
    }
}

fun main() {
    RedundantConnection().findRedundantConnection(
        arrayOf(
            intArrayOf(3, 4),
            intArrayOf(1, 2),
            intArrayOf(2, 4),
            intArrayOf(3, 5),
            intArrayOf(2, 5),
        )
    )
    RedundantConnection().findRedundantConnection(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 3),
        )
    )
}