package o_n_o_z_Remove_All_Occurrences_Substring

import java.lang.StringBuilder

class RemoveAllOccurrencesSubstring {
    fun removeOccurrences2(s: String, part: String): String {
        val stack = ArrayDeque<Char>()
        var j = 0
        val result = StringBuilder()

        for (i in s.indices) {
            stack.addLast(s[i])

            if (s[i] != part[j]) {
                if (s[i] != part[0]) j = 0
                else j = 1
            } else j++

            if (j == part.length) {
                repeat(j) { stack.removeLast() }
                j = getJ(stack, part)
                stack.forEach { print("$it, ") }
                println()
            }
        }
        return result.toString()
    }

    fun removeOccurrences(s: String, part: String): String {
        var s = s

        while (s.contains(part)) {
            val i = s.indexOf(part)
            s = s.removeRange(i, i + part.length)
        }

        return s
    }

    fun getJ(stack: ArrayDeque<Char>, part: String): Int {
        var j = 0

        for (i in stack.indices) {
            if (stack[i] != part[j]) j = 0
            else j++
        }

        return j
    }
}

fun main() {
    RemoveAllOccurrencesSubstring().removeOccurrences(s = "daabcbaabcbc", part = "abc")
}