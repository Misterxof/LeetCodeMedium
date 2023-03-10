package th_e_t_Linked_List_Random_Node

class LinkedListRandomNode(val head: ListNode?) {

    fun getRandom(): Int {
        var node = head
        var size = 0

        while (node != null) {
            size++
            node = node.next
        }

        var random = (1..size).random()
        node = head

        if (random == 1) return head!!.`val`
        else {
            while (random != 1) {
                node = node!!.next
                random--
            }
        }
        return node!!.`val`
    }

}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

