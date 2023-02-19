package o_z_th_Binary_Tree_Zigzag_Level_Order_Traversal

class BinaryTreeZigzagLevelOrderTraversal {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val list = mutableListOf<MutableList<Int>>()

        if (root != null) {
            val queue = ArrayDeque<TreeNode?>()
            queue.add(root)

            // BFS
            while (queue.isNotEmpty()) {
                val levelList = mutableListOf<Int>()

                // for each level
                repeat(queue.size) {
                    var cur = queue.removeFirst()

                    cur?.let {
                        if (it.left != null) queue.add(it.left)
                        if (it.right != null) queue.add(it.right)

                        if (list.size % 2 == 0) levelList.add(it.`val`)
                        else levelList.add(0, it.`val`)
                    }
                }
                if (levelList.isNotEmpty()) list.add(levelList)
            }
        }
        return list
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}