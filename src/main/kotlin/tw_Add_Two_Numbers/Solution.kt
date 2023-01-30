package tw_Add_Two_Numbers

class Solution {
    fun addTwoNumbers(head1: Array<Int>, head2: Array<Int>) {
        val list1 = ListNode(head1)
        val list2 = ListNode(head2)
         list1.addTwoNumbers(list1.firstNode, list2.firstNode)
    }

    // Solution for LeetCode
    //  fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    //        var l1 = l1
    //        var l2 = l2
    //        var firstList: MutableList<Int> = mutableListOf()
    //        var secondList: MutableList<Int> = mutableListOf()
    //
    //        while (l1 != null) {
    //            firstList.add(l1.`val`)
    //            l1 = l1.next
    //        }
    //
    //        while ( l2  != null) {
    //            secondList.add(l2.`val`)
    //            l2 = l2.next
    //        }
    //
    //        val firstNumber = firstList.reversed().joinToString(separator = "").toBigInteger()
    //        val secondNumber = secondList.reversed().joinToString(separator = "").toBigInteger()
    //        val resultNumber = firstNumber + secondNumber
    //        val r = "$resultNumber".map { it.toString().toBigInteger() }
    //        return getListNode(r)
    //    }
    //
    //     private fun getListNode(list: List<BigInteger>): ListNode? {
    //        var node: ListNode? = null
    //        list.forEach{
    //            val nextNode = ListNode(it.toInt())
    //            nextNode.next = node
    //            node = nextNode
    //        }
    //        return node
    //    }
}