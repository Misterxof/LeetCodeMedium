package e_z_t_Find_Eventual_Safe_States

class FindEventualSafeStates {
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        val nodes = Array(graph.size) { Node(graph[it]) }

        for (i in nodes.indices)
            if (dfs(nodes[i], nodes)) result.add(i)

        return result
    }

    fun dfs(node: Node, nodes: Array<Node>): Boolean {
        if (node.state != 0) return node.state == 2

        node.state = 1
        for (i in node.links) {
            if (!dfs(nodes[i], nodes)) return false
        }
        node.state = 2
        return true
    }

    class Node(val links: IntArray, var state: Int = 0)
}