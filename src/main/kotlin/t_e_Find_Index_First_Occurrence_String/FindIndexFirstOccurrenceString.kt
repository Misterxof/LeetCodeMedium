package t_e_Find_Index_First_Occurrence_String

class FindIndexFirstOccurrenceString {
    fun strStr(haystack: String, needle: String): Int {
        var index = -1
        var i = 0
        var j = 0

        if (needle.length > haystack.length) return -1

        while (i < haystack.length) {
            println("i=$i j=$j in=$index")
            when{
                j == needle.length -> return index
                haystack[i] == needle[j] && j == 0 -> {
                    if (haystack.length - i < needle.length) return -1
                    
                    index = i
                    j++
                }
                haystack[i] == needle[j] -> {
                    j++
                }
                else -> {
                    if (index != -1) i = index
                    index = -1
                    j = 0
                }
            }
            i++
        }

        return index
    }
}

fun main() {
//    println(FindIndexFirstOccurrenceString().strStr("sdadbutsad", "sad"))
    println(FindIndexFirstOccurrenceString().strStr("mississippi", "issipi"))
}