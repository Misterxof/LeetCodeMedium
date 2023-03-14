package o_t_n_Sum_Root_Leaf_Numbers

import o_z_n_Convert_Sorted_List_Binary_Search_Tree.TreeNode
import java.util.TreeMap
import java.util.TreeSet

class SumRootLeafNumbers {
    fun sumNumbers(root: TreeNode?): Int {
        val allNumbers = getAllNumbers(root, "", mutableListOf())
        return allNumbers.sum()
    }

    fun getAllNumbers(root: TreeNode?, curNumber: String, list: MutableList<Int>): List<Int> {
        if (root != null) {
            val curNumber = curNumber + root!!.`val`
            when {
                root.left != null && root.right != null -> {
                    getAllNumbers(root.left, curNumber, list)
                    getAllNumbers(root.right, curNumber, list)
                }
                root.left != null && root.right == null -> getAllNumbers(root.left, curNumber, list)
                root.right != null && root.left == null -> getAllNumbers(root.right, curNumber, list)
                root.right == null && root.left == null -> list.add(curNumber.toInt())
            }
        }

        return list
    }
}