package o_z_n_Convert_Sorted_List_Binary_Search_Tree

class ConvertSortedListBinarySearchTree {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        var current = head
        var size = 0

        while (current != null) {
            size++
            current = current.next
        }

        var middleIndex = size / 2
        var middle: ListNode? = null

        if (middleIndex != 0 && head != null) {
            current = head

            while (middleIndex != 0) {
                current = current!!.next
                middleIndex--
                middle = current
            }
        } else if (middleIndex == 0 && head != null) {
            middle = head
        } else {
            return null
        }

        val root = TreeNode(middle!!.`val`)
        current = head

        while (current != null) {
            if (current.`val` != root.`val`) {
                addTreeNode(current.`val`, root)
            }
            current = current.next
        }

        return root
    }

    fun addTreeNode(`val`: Int, root: TreeNode) {
        var current: TreeNode? = root

        while (true) {
            val parent = current

            if (`val` < current!!.`val`) {
                current = current.left

                if (current == null) {
                    parent!!.left = TreeNode(`val`)
                    break
                }
            } else {
                current = current.right

                if (current == null) {
                    parent!!.right = TreeNode(`val`)
                    break
                }
            }
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "ListNode(`val`=$`val`, next=$next)"
    }
}

fun initializeListNode(intArray: IntArray) : ListNode? {
    intArray.reverse()
    var root: ListNode? = null
    var i = intArray.lastIndex

    while (i != -1) {
        val node = ListNode(intArray[i])
        node?.next = root
        root = node
        i--
    }

    return root
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode(`val`=$`val`, left=$left, right=$right)"
    }
}

fun main() {
    var root = initializeListNode(intArrayOf(-10,-3,0,5,9))
    println(root)
    var conv = ConvertSortedListBinarySearchTree().sortedListToBST(root)
    println(conv)

    root = initializeListNode(intArrayOf())
    println(root)
    conv = ConvertSortedListBinarySearchTree().sortedListToBST(root)
    println(conv)
}