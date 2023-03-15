package n_fi_e_Check_Completeness_Binary_Tree

import o_z_n_Convert_Sorted_List_Binary_Search_Tree.TreeNode

class CheckCompletenessBinaryTree {
    fun isCompleteTree(root: TreeNode?): Boolean {
        if (root == null) return false
        val arr = treeToList(root, mutableListOf())
        var result = true
        var prev = arr[0]

        for (i in 1 until arr.size) {
            if ((prev == 0 && arr[i] == 0) || (prev == 1 && arr[i] == 1)) {
                return false
            }
            prev = arr[i]
        }
        
        return result
    }

    fun treeToList(root: TreeNode?, list: MutableList<Int>): List<Int> {
        val queue = ArrayDeque<TreeNode>()
        queue.add(root!!)

        while (queue.isNotEmpty()) {
            val root = queue.removeFirst()
            when {
                root!!.left != null && root!!.right != null -> {
                    queue.add(root.left!!)
                    queue.add(root.right!!)
                    list.add(1)
                    list.add(0)
                }

                root!!.left != null && root!!.right == null -> {
                    queue.add(root.left!!)
                    list.add(1)
                }

                root!!.right != null && root!!.left == null -> {
                    queue.add(root.right!!)
                    list.add(3)
                }

                root!!.left == null && root!!.right == null -> {
                    if (queue.isNotEmpty() && (queue.first().left != null || queue.first().right != null)) list.add(3)
                }
            }
        }
        return list
    }
}