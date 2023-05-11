package se_z_se_Design_Linked_List

class DesignLinkedList {
    var head: LinkedListNode? = null
    var tail: LinkedListNode? = null
    var size = 0

    class LinkedListNode(
        var `val`: Int,
        var next: LinkedListNode?
    ) {
        override fun toString(): String {
            return "LinkedListNode(`val`=$`val`, next=$next)"
        }
    }

    fun get(index: Int): Int {
        if (size == 0 || index > size) return -1
        if (size > 0 && index == size - 1) return tail!!.`val`

        var counter = 0
        var next = head

        while (next != null) {
            if (counter == index) return next.`val`
            next = next.next
            counter++
        }
        return -1
    }

    fun addAtHead(`val`: Int) {
        if (size == 0) {
            head = LinkedListNode(`val`, null)
            tail = head
        } else {
            val newNode = LinkedListNode(`val`, head)
            head = newNode
        }
        size++
    }

    fun addAtTail(`val`: Int) {
        if (size == 0) {
            head = LinkedListNode(`val`, null)
            tail = head
        } else {
            val newNode = LinkedListNode(`val`, null)
            tail!!.next = newNode
            tail = newNode
        }
        size++
    }

    fun addAtIndex(index: Int, `val`: Int) {
        if (index > size || index < 0) return

        when (index) {
            0 -> addAtHead(`val`)
            size -> addAtTail(`val`)
            else -> {
                var prev = head
                var next = head
                var counter = 0

                while (next != null) {
                    if (counter == index) {
                        val newNode = LinkedListNode(`val`, next)
                        prev!!.next = newNode
                        size++
                        return
                    }
                    prev = next
                    next = next.next
                    counter++
                }
            }
        }
    }

    fun deleteAtIndex(index: Int) {
        if (index > size - 1) return

        when (index) {
            0 -> {
                head = head!!.next
                size--
            }

            size - 1 -> {
                val prev = findPrevNode(tail!!)
                prev!!.next = null
                tail = prev
                size--
            }

            else -> {
                var prev = head
                var next = head
                var counter = 0

                while (next != null) {
                    if (counter == index) {
                        prev!!.next = next.next
                        size--
                        return
                    }
                    prev = next
                    next = next.next
                    counter++
                }
            }
        }
    }

    fun findPrevNode(node: LinkedListNode): LinkedListNode? {
        var prev = head
        var next = head

        while (next != null) {
            if (next == node) {
                return prev!!
            }
            prev = next
            next = next.next
        }

        return null
    }

    fun print() {
        print("size $size ")
        println(head)
    }
}

fun main() {
    val list = DesignLinkedList()
    list.addAtHead(2)
    list.print()
    list.addAtHead(1)
    list.print()
    list.addAtHead(0)
    list.print()
    list.addAtIndex(2, 3)
    list.print()
    list.addAtIndex(0, -1)
    list.print()
    list.addAtIndex(list.size, 4)
    list.print()
    list.deleteAtIndex(0)
    list.print()
    list.deleteAtIndex(4)
    list.print()
//    list.addAtHead(2)
//    list.print()
//    list.addAtHead(1)
//    list.print()
//    list.addAtIndex(3, 0)
//    list.print()
//    list.deleteAtIndex(2)
//    list.print()
//    list.addAtHead(6)
//    list.print()
//    list.addAtTail(4)
//    list.print()

    println(list.get(4))
}