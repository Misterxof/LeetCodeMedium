package o_th_n_Word_Break

class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        var currentWord = StringBuilder()
        var currentWord2 = StringBuilder()
        var flag = false
        var max = 0

        wordDict.forEach { max = maxOf(it.length, max) }

        s.forEach outer@ {
            currentWord.append(it)
            if (flag)
                currentWord2.append(it)
           // println(check(currentWord.toString(), wordDict))
            if (currentWord2.isNotBlank()) {
              //  println("1 $currentWord2")


                if (check(currentWord2.toString(), wordDict))
                    currentWord2.clear()

                    if (currentWord2.length == max)
                        currentWord2.clear()
            }
            if (check(currentWord.toString(), wordDict)) {
                if (currentWord2.isBlank())
                    currentWord2.append(currentWord)
                flag = true
                currentWord.clear()
            }

        }

//        println(currentWord)
//        println(currentWord2)
        return currentWord.isBlank() || (currentWord2.isBlank() && flag)
    }

    fun check(currentWord: String, wordDict: List<String>): Boolean {
        wordDict.forEach { word ->
           // println("c $currentWord w $word")
            if (word == currentWord) {
                return true
            }
        }

        return false
    }

    //wordDict.forEach { word ->
    //            println("c $currentWord w $word")
    //            if (word == currentWord.toString()) {
    //                currentWord.clear()
    //                return@outer
    //            }
    //        }
}

fun main() {
    println(WordBreak().wordBreak("leetcode", listOf("leet","code")))
    println(WordBreak().wordBreak("applepenapple", listOf("apple","pen")))
    println(WordBreak().wordBreak("catsandog", listOf("cats","dog","sand","and","cat")))
    println(WordBreak().wordBreak("aaaaaaa", listOf("aaaa","aaa")))
    println(WordBreak().wordBreak("b", listOf("a")))
    println(WordBreak().wordBreak("dcacbcadcad", listOf("cbd","dca","bcdc","dcac","ad")))
    println(WordBreak().wordBreak("catskicatcats", listOf("cats","cat","dog","ski")))
}