package t_o_o_s_Check_Parentheses_String_Valid

import java.util.Stack

class CheckParenthesesStringValid {
    fun canBeValid(s: String, locked: String): Boolean {
        val open = Stack<Int>()
        val unlocked = Stack<Int>()

        if (s.length % 2 != 0) return false

        // remove all locked )
        for (i in s.indices) {
            if (locked[i] == '0') unlocked.add(i)
            else if (s[i] == '(') open.add(i)
            else if (s[i] == ')') {
                if (open.isNotEmpty()) open.removeLast()
                else if (unlocked.isNotEmpty()) unlocked.removeLast()
                else return false
            }
        }

        // remove all locked (
        while (
            open.isNotEmpty() &&
            unlocked.isNotEmpty() &&
            open.last() < unlocked.last()) {
            open.removeLast()
            unlocked.removeLast()
        }

        return open.isEmpty()
    }
}

fun main() {
    println(CheckParenthesesStringValid().canBeValid("))()))", "010100"))
    println(CheckParenthesesStringValid().canBeValid(s = "()()", locked = "0000"))
    println(CheckParenthesesStringValid().canBeValid(s = ")", locked = "0"))
    println(CheckParenthesesStringValid().canBeValid("()))", "0010"))
}