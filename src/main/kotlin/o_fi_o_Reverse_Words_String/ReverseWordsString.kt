package o_fi_o_Reverse_Words_String

import java.lang.StringBuilder


class ReverseWordsString {

    fun reverseWordsNW(s: String): String {
        val sentence = StringBuilder()
        var start = s.lastIndex
        var end = s.length

        for (i in s.lastIndex downTo 0) {
            if (s[i] == ' ' && start != end) {
                sentence.append("${s.subSequence(i + 1, end)} ")
                end = i
            }
            if (s[i] != ' ') {
                start--
            }
        }


        if (start != end) {
            sentence.append("${s.subSequence(0, end)}")
        }

        return sentence.toString()
    }

    fun reverseWords(s: String): String {
        val word = StringBuilder()
        var sentence = ""

        for (i in s.indices) {
            if (s[i] == ' ' && word.isNotBlank()) {
                sentence = if (sentence.isNotBlank()) "$word $sentence"
                else "$word$sentence"
                word.clear()
            }
            if (s[i] != ' ') {
                word.append(s[i])
            }
        }

        if (word.isNotBlank()) {
            sentence = if (sentence.isNotBlank()) "$word $sentence"
            else "$word$sentence"
            word.clear()
        }
        sentence += "."

        return sentence
    }

    fun reverseWords2(s: String): String {
        val queue = ArrayDeque<String>()
        val word = StringBuilder()

        for (i in s.indices) {
            if (s[i] == ' ' && word.isNotBlank()) {
                queue.addLast(word.toString())
                word.clear()
            }
            if (s[i] != ' ') {
                word.append(s[i])
            }
        }

        if (word.isNotBlank()) {
            queue.addLast(word.toString())
            word.clear()
        }

        while (queue.isNotEmpty()) {
            if (word.isNotBlank()) word.append(" ")

            word.append(queue.removeLast())
        }

        return word.toString()
    }
}

fun main() {
    println(ReverseWordsString().reverseWords("the sky is blue"))
    println(ReverseWordsString().reverseWords("EPY2giL"))
    println(ReverseWordsString().reverseWords("  hello world  "))
}