package o_f_t_Linked_List_Cycle_II

import tw_Add_Two_Numbers.ListNode

class LinkedListCycleII {
    fun detectCycle(head: Array<Int>) {
        val list1 = ListNode(head)
        list1.getListNodeCircle(list1.firstNode, 1)
    }

    // LeetCode solution
    // fun detectCycle(head: ListNode?): ListNode? {
    //        var node = head
    //        var set: HashSet<ListNode> = HashSet()
    //
    //        while(node != null) {
    //            if (!set.add(node))
    //                return node
    //            else
    //                set.add(node!!)
    //
    //            node = node.next
    //        }
    //
    //        return null
    //    }
}

fun main() {
    LinkedListCycleII().detectCycle(arrayOf(3,2,0,-4))
}