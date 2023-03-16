package o_z_s_Construct_Binary_Tree_Inorder_Postorder_Traversal

import o_z_n_Convert_Sorted_List_Binary_Search_Tree.TreeNode

class ConstructBinaryTreeInorderPostorderTraversal {
    var index = 0

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val inorderMap = hashMapOf<Int, Int>()

        for (i in inorder.indices)
            inorderMap[inorder[i]] = i

        return insertNode(0, inorder.lastIndex, inorderMap, postorder)
    }

    private fun insertNode(left: Int, right: Int, inorderMap: HashMap<Int, Int>, postorder: IntArray): TreeNode? {
        if (left > right) return null

        val nodeRoot = postorder[postorder.size - 1 - index++]
        val root = TreeNode(nodeRoot)
        val inorderIndex = inorderMap[nodeRoot]!!

        root.right = insertNode(inorderIndex + 1, right, inorderMap, postorder)
        root.left = insertNode(left, inorderIndex - 1, inorderMap, postorder)

        return root
    }
}