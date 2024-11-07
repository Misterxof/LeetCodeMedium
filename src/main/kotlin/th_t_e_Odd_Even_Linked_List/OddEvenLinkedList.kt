package th_t_e_Odd_Even_Linked_List

class OddEvenLinkedList {
    fun oddEvenList(head: ListNode?): ListNode? {
        var num = head
        var odd: ListNode? = null
        var oddHead: ListNode? = null
        var even: ListNode? = null
        var evenHead: ListNode? = null
        var counter = 1

        while(num != null) {
            if (counter %2 == 0) {
                if (even == null) {
                    even = ListNode(num.`val`)
                    evenHead = even
                }
                else {
                    even.next = ListNode(num.`val`)
                    even = even.next
                }
            } else {
                if (odd == null) {
                    odd = ListNode(num.`val`)
                    oddHead = odd
                }
                else {
                    odd.next = ListNode(num.`val`)
                    odd = odd.next
                }
            }
            counter++
            num = num.next
        }
        odd?.next = evenHead

        return oddHead
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
}