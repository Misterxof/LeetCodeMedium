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

        middle = if (middleIndex != 0 && head != null) {
            findElement(middleIndex, head)
        } else head ?: return null

        val root = TreeNode(middle!!.`val`)

        if (head.next != null) addListNode(root, head, size, true)

        return root
    }

    fun addListNode(root: TreeNode, head: ListNode, size: Int, isFirst: Boolean) {
        if (head.next == null) addTreeNode(head.`val`, root)
        else {
            var current: ListNode? = head
            var middleIndex = size / 2
            while (middleIndex != 0) {
                if (isFirst){
                    var parent = current
                    current = current!!.next!!
                    middleIndex--
                    if (middleIndex == 0) {
                        val tail = current.next
                        parent!!.next = null
                        addListNode(root, head, size / 2, false)
                        tail?.let {
                            addListNode(root, tail!!, (size - size / 2) - 1, false)
                        }
                        break
                    }
                }
                else {
                    var parent = current
                    current = current!!.next!!
                    middleIndex--
                    if (middleIndex == 0) {
                        addTreeNode(current.`val`, root)
                        val tail = current.next
                        parent!!.next = null
                        addListNode(root, head, size / 2, false)
                        tail?.let {
                            addListNode(root, tail!!, (size - size / 2) - 1, false)
                        }
                        break
                    }
                }
            }
        }
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

    fun findElement(index: Int, head: ListNode): ListNode {
        var current = head
        var index = index
        var middle: ListNode = ListNode(0)

        while (index != 0) {
            current = current.next!!
            index--
            middle = current
        }
        return middle
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "ListNode(`val`=$`val`, next=$next)"
    }
}

fun initializeListNode(intArray: IntArray) : ListNode? {
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
    println()

    root = initializeListNode(intArrayOf())
    println(root)
    conv = ConvertSortedListBinarySearchTree().sortedListToBST(root)
    println(conv)
    println()

    root = initializeListNode(intArrayOf(0,1,2,3,4,5))
    println(root)
    conv = ConvertSortedListBinarySearchTree().sortedListToBST(root)
    println(conv)
    println()

    root = initializeListNode(intArrayOf(1, 3))
    println(root)
    conv = ConvertSortedListBinarySearchTree().sortedListToBST(root)
    println(conv)
    println()
}