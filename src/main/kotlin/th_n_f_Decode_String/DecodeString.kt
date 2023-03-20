package th_n_f_Decode_String

class DecodeString {
    fun decodeString(s: String): String {
        val numberStack = ArrayDeque<Int>()
        val bracesStack = ArrayDeque<Char>()
        val stringStack = ArrayDeque<String>()
        var currentString = ""
        var currentDigit = ""
        var result = ""

        fun addString() {
            if (stringStack.isEmpty()) stringStack.addFirst(currentString)
            else {
                stringStack.set(0, stringStack.first() + currentString)
            }
            currentString = ""
        }

        for (i in s.indices) {
            when {
                s[i].isDigit() -> {
                    currentDigit += s[i]

                    if (currentString.isNotBlank()) {
                        if (numberStack.isEmpty()) {
                            result += currentString
                            currentString = ""
                        } else addString()
                    }
                    if (!s[i + 1].isDigit()) {
                        numberStack.addFirst(currentDigit.toInt())
                        currentDigit = ""
                    }
                }

                s[i] == '[' -> bracesStack.addFirst(s[i])

                s[i] == ']' -> {
                    if (currentString.isNotBlank()) addString()

                    val str = stringStack.removeFirst()
                    bracesStack.removeFirst()
                    println(result)
                    println(str)
                    println(stringStack)
                    repeat(numberStack.removeFirst()) {
                        if (bracesStack.isEmpty()) result += str
                        else {
                            if (stringStack.isNotEmpty())
                                stringStack.set(0, stringStack.first() + str)
                            else stringStack.addFirst(str)
                        }
                    }
                }

                else -> currentString += s[i]
            }
        }
        result += currentString
        return result
    }

}

fun main() {
//    println(DecodeString().decodeString("3[a]2[bc]"))
//    println(DecodeString().decodeString("2[abc]3[cd]ef"))
//    println(DecodeString().decodeString("3[a2[c]]"))
//    println(DecodeString().decodeString("100[leetcode]"))
    println(DecodeString().decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"))
}