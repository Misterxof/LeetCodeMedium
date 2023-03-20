package t_th_fi_Lowest_Common_Ancestor_Binary_Search_Tree

import o_z_n_Convert_Sorted_List_Binary_Search_Tree.TreeNode

class LowestCommonAncestorBinarySearchTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        var min: TreeNode? = null
        var current = root

        while (true) {
            when {
                p!!.`val` == current.`val` && (q!!.`val` < current.`val` ||  q!!.`val` > current.`val`) -> return p
                q!!.`val` == current.`val` && (p!!.`val` < current.`val` ||  p!!.`val` > current.`val`) -> return q
                (q!!.`val` < current.`val` && p!!.`val` > current.`val`) ||
                        (p!!.`val` < current.`val` && q!!.`val` > current.`val`) -> {
                    if (min != null) {
                        if (min.`val` > current.`val`) min = current
                    }
                    else min = current
                }
            }
        }
    }
}