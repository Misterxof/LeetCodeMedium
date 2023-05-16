package o_f_t_Linked_List_Cycle_II


class LinkedListCycleII {
//    fun detectCycle(head: Array<Int>) {
//        val list1 = ListNode(head)
//        list1.getListNodeCircle(list1.firstNode, 1)
//    }

    // LeetCode solution
    fun detectCycle2(head: ListNode?): ListNode? {
        var node = head
        var set: HashSet<ListNode> = HashSet()

        while (node != null) {
            if (!set.add(node))
                return node
            else
                set.add(node!!)

            node = node.next
        }

        return null
    }

    // Two pointers
    fun detectCycle(head: ListNode?): ListNode? {
        var slowPointer = head
        var fastPointer = head

        while (slowPointer != null && fastPointer != null) {
            slowPointer = slowPointer?.next
            fastPointer = fastPointer?.next?.next

            if (slowPointer == fastPointer)
                break
        }

        if (fastPointer == null) return null
        slowPointer = head

        while (slowPointer != fastPointer) {
            slowPointer = slowPointer?.next
            fastPointer = fastPointer?.next
        }

        return slowPointer
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}

fun main() {
//    LinkedListCycleII().detectCycle(arrayOf(3, 2, 0, -4))
}