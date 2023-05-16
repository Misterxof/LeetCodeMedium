package o_n_Remove_Node_End_List

class RemoveNodeEndList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var size = 0
        var node = head

        while (node != null) {
            size++
            node = node.next
        }

        val remove = size - n
        var prevNode: ListNode? = null
        node = head
        size = 0

        while (node != null) {
            if (size == remove - 1) {
                prevNode = node
            }
            if (size == remove) {
                if (size == 0 ) return node.next
                else prevNode!!.next = node.next
                return head
            }
            size++
            node = node.next
        }

        return head
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}