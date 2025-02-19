package o_f_o_fi_Lexicographical_String_All_Happy_Strings_Length

import com.sun.source.tree.Tree
import java.util.TreeSet

class LexicographicalStringAllHappyStringsLength {
    fun getHappyString(n: Int, k: Int): String {
        val set = TreeSet<String>()

        getHappyStrings(StringBuilder("a"), set, n - 1)
        getHappyStrings(StringBuilder("b"), set, n - 1)
        getHappyStrings(StringBuilder("c"), set, n - 1)

        return set.elementAtOrNull(k - 1) ?: ""
    }

    fun getHappyStrings(s: StringBuilder, set: TreeSet<String>, n: Int) {
        if (n == 0) {
            set.add(s.toString())
            return
        }

        when(s.last()) {
            'a' -> {
                val seq = s.toString()
                getHappyStrings(StringBuilder(seq + "b"), set, n - 1)
                getHappyStrings(StringBuilder(seq + "c"), set, n - 1)
            }
            'b' -> {
                val seq = s.toString()
                getHappyStrings(StringBuilder(seq + "a"), set, n - 1)
                getHappyStrings(StringBuilder(seq + "c"), set, n - 1)
            }
            'c' -> {
                val seq = s.toString()
                getHappyStrings(StringBuilder(seq + "a"), set, n - 1)
                getHappyStrings(StringBuilder(seq + "b"), set, n - 1)
            }
        }
    }
}

fun main() {
    println(LexicographicalStringAllHappyStringsLength().getHappyString(3,9))
}