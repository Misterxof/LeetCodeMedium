package o_z_t_Binary_Tree_Level_Order_Traversal

import o_z_th_Binary_Tree_Zigzag_Level_Order_Traversal.TreeNode

class BinaryTreeLevelOrderTraversal {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
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

                        levelList.add(it.`val`)
                    }
                }
                if (levelList.isNotEmpty()) list.add(levelList)
            }
        }
        return list
    }
}