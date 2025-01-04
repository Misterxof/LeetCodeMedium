package o_n_th_z_Unique_Length_Palindromic_Subsequences

class UniqueLengthPalindromicSubsequences {
    // too slow
    fun countPalindromicSubsequence(s: String): Int {
        val hashSet = HashSet<String>()
        var i = 0
        var s = s

        while (i < s.lastIndex - 1) {
            getSubstr(s.substring(i + 1, s.length), "${s[i]}", hashSet)
            i++
        }

     //   hashSet.forEach { print("$it, ") }

        return hashSet.size
    }

    fun getSubstr(s: String, f: String, hashSet: HashSet<String>) {
     //   println("f $f s $s")
        var f = f

        loop@ for (i in 0..s.lastIndex) {
            if (f.length == 1){
                getSubstr(s.substring(i + 1, s.length), "$f${s[i]}", hashSet)
            } else {
               // println("s ${s[i]} 0f ${f[0]} $f${s[i]}")
                if (s[i] == f[0]) {
//                    println("add")
                    hashSet.add("$f${s[i]}")
                    break@loop
                }
            }
        }
    }

    fun countPalindromicSubsequence2(s: String): Int {
        var result = 0

        for (i in 'a'..'z') {
            val first = s.indexOf(i)
            val last = s.lastIndexOf(i)

            if (first != -1 && last != -1 && last > first) {
                result += s.substring(first + 1, last).toSet().size
            }
        }

        return result
    }
}

fun main() {
    println(UniqueLengthPalindromicSubsequences().countPalindromicSubsequence2("aabcaa"))
    println(UniqueLengthPalindromicSubsequences().countPalindromicSubsequence2("adc"))
    println(UniqueLengthPalindromicSubsequences().countPalindromicSubsequence2("bbcbaba"))
}