package f_f_th_String_Compression

class StringCompression {
    fun compress(chars: CharArray): Int {
        if (chars.size == 1) return chars.size

        var i = 0
        var counter = 1

        for (j in chars.indices) {
            if (j == chars.lastIndex) {
                chars[i++] = chars[j]
                if (counter > 1) counter.toString().forEach { chars[i++] = it }
                break
            }
            if (chars[j] == chars[j + 1]) counter++
            else {
                chars[i++] = chars[j]
                if (counter > 1) counter.toString().forEach { chars[i++] = it }
                counter = 1
            }
        }

        return i
    }
}

fun main() {
    //println(StringCompression().compress(charArrayOf('a','a','b','b','c','c','c')))
    println(StringCompression().compress(charArrayOf('a','b','b','b','b','b','b','b','b','b','b','b','b')))
}