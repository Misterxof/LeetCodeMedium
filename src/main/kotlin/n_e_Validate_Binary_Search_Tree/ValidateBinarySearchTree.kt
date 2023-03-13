package n_e_Validate_Binary_Search_Tree

import o_z_n_Convert_Sorted_List_Binary_Search_Tree.TreeNode

class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    fun isValidBST(root: TreeNode?, min: Long, max: Long): Boolean {
        if (root == null) return true

        return root.`val` in (min + 1) until max && isValidBST(root.left, min, root.`val`.toLong())
                && isValidBST(root.right, root.`val`.toLong(), max)
    }
}