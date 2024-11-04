package th_o_s_th_String_CompressionIII

class StringCompressionIII {
    fun compressedString(word: String): String {
        var charArr = CharArray(word.length * 2)
        var counter = 1
        var j = 0

        loop@for (i in word.indices) {
            if (i + 1 < word.length) {
                if (word[i] == word[i + 1]) {
                    if (counter == 9) {
                        charArr[j++] = counter.digitToChar()
                        charArr[j++] = word[i]
                        counter = 1
                        continue@loop
                    }
                    counter++
                }
                else {
                    charArr[j++] = counter.digitToChar()
                    charArr[j++] = word[i]
                    counter = 1
                }
            } else {
                charArr[j++] = counter.digitToChar()
                charArr[j++] = word[i]
                counter = 1
            }
        }
        return charArr.joinToString(separator = "") { if(it == '\u0000') "" else it.toString()}
    }
}

fun main() {
    println(StringCompressionIII().compressedString("abcde"))
    println(StringCompressionIII().compressedString("aaaaaaaaaaaaaabbe"))
    println(StringCompressionIII().compressedString("aaaaaaaaay"))
}