package tw_Add_Two_Numbers

import java.math.BigInteger

open class ListNode(val head: Array<Int>) {
    var firstNode: Node
    private var size = head.size

    init {
        firstNode = initNodes(0)
    }

    private fun initNodes(index: Int): Node {
        var node = if (index + 1 <= head.indices.last) {
            Node(head[index], initNodes(index + 1))
        } else {
            Node(head[index], null)
        }
        return node
    }

    private fun getListNode(list: List<Int>): Node? {
        var node: Node? = null
        list.forEach {
            val nextNode = Node(it.toInt())
            nextNode.next = node
            node = nextNode
        }
        return node
    }

    fun getListNodeCircle(nodel: Node, pos: Int): Node? {
        var node: Node? = nodel
        var nodeCicle: Node? = null
        var i = 0

        while (true) {
            if (i == pos) nodeCicle = node


            if (node?.next == null) {
                node?.data = 999
                node?.next = nodeCicle
                break
            }
            node = node!!.next
            i++
        }

        return node
    }

    // 142. Linked List Cycle II
    fun detectCycle(head: Node?): Node? {
        var node = head
        var list: MutableList<Node> = mutableListOf()

        while(node != null) {
            if (list.contains(node))
                return node
            else
                list.add(node!!)

            node = node.next
        }

        return null
    }

    // 2. Add Two Numbers
    fun addTwoNumbers(l1: Node?, l2: Node?) {
        var l1 = l1
        var l2 = l2
        var firstList: MutableList<Int> = mutableListOf()
        var secondList: MutableList<Int> = mutableListOf()

        while (l1 != null) {
            firstList.add(l1.data)
            l1 = l1.next
        }

        while (l2 != null) {
            secondList.add(l2.data)
            l2 = l2.next
        }

        val firstNumber = firstList.reversed().joinToString(separator = "").toBigInteger()
        val secondNumber = secondList.reversed().joinToString(separator = "").toBigInteger()
        val resultNumber = firstNumber + secondNumber
        val r = "$resultNumber".map { it.toString().toBigInteger() }
            .reversed()    // leetcode will reverse resulted ListNode
    }

    // 876. Middle of the Linked List
    fun getMiddle(): Node {
        val array: MutableList<Node> = mutableListOf()
        var node: Node? = firstNode

        while (node != null) {
            array.add(node)
            node = node.next
        }

        var middleItem = array.size / 2

        return array[middleItem]
    }

    // 234. Palindrome Linked List
    fun check(): Boolean {
        val deque: ArrayDeque<Int> = ArrayDeque()
        val result = false
        var node: Node? = firstNode
        while (node != null) {
            deque.add(node.data)
            node = node.next
        }

        while (deque.size > 0) {
            if (deque.size > 2) {
                if (deque.removeFirst() != deque.removeLast())
                    return false
            } else {
                return if (deque.size == 1) true
                else deque.first() == deque.last()
            }
        }

        return result
    }

    fun isPalindrome(): Boolean {
        var result = false

        if (size == 1)
            return true

        while (size > 0) {
            result = checkFirstAndLast()
            if (!result)
                return false
        }

        return result
    }

    private fun checkFirstAndLast(): Boolean {
        var result = false
        val last = getLast(firstNode)

        if (firstNode.data == last.data) {
            if (size == 2) {
                size = 0
                return true
            } else {
                removeFirst()
                removeLast()
                result = true
            }
        } else {
            if (size == 2) {
                size = 0
                return false
            }
        }
        return result
    }

    private fun removeFirst() {
        if (firstNode.next != null) {
            firstNode = firstNode.next!!
            size--
        }
    }

    private fun removeLast() {
        if (firstNode.next == null) {
            size--
            return
        } else {
            var isEnd = false
            var temp: Node = firstNode
            var prev: Node? = null

            while (!isEnd) {
                if (temp.next != null) {
                    prev = temp
                    temp = temp.next!!
                } else {
                    prev!!.next = null
                    isEnd = true
                }
            }

            size--
        }
    }

    private fun getLast(node: Node): Node {
        return if (node.next == null) {
            node
        } else {
            getLast(node.next!!)
        }
    }

    fun print(node: Node) {
        var nodeTemp: Node = node
        for (i in 0 until 10) {
            println(nodeTemp.data)
            nodeTemp = nodeTemp.next!!
        }
    }

    data class Node(var data: Int, var next: Node? = null)   // if node is circled toString will throw Overflow, data class has its own toString
}