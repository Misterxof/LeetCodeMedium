package fi_s_se_Permutation_String

import java.util.*
import kotlin.collections.HashMap

class PermutationString {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val s1HashMap: HashMap<Char, Int> = hashMapOf()
        val s2HashMap: HashMap<Char, Int> = hashMapOf()

        // count s1 letters\
        s1.forEach {
            if (s1HashMap.contains(it))
                s1HashMap[it] = s1HashMap[it]!! + 1
            else
                s1HashMap[it] = 1
        }

        s2.forEachIndexed { i, it ->
            val index = i - s1.length

            // count s2 letters one by one
            if (s2HashMap.contains(it))
                s2HashMap[it] = s2HashMap[it]!! + 1
            else
                s2HashMap[it] = 1

            // use window sliding technique, k = s1.length
            if (i >= s1.length) {
                s2HashMap[s2[index]] = s2HashMap[s2[index]]!! - 1

                if (s2HashMap[s2[index]] == 0)
                    s2HashMap.remove(s2[index])
            }

            if (s1HashMap == s2HashMap) return true
        }

        return false
    }

    // more simpler solution
    fun checkInclusion2(s1: String, s2: String): Boolean {
        val freq1 = IntArray(26) { 0 }
        val freq2 = IntArray(26) { 0 }

        // count s1 letters
        s1.forEach { freq1[it.toInt() - 'a'.toInt()]++ }

        for (i in 0..s2.lastIndex) {
            // count s2 letters one by one
            freq2[s2[i].code - 'a'.code]++
            // use window sliding technique, k = s1.length
            if (i >= s1.length) freq2[s2[i - s1.length].code - 'a'.code]--

            if (freq1 == freq2) return true
        }
        return false
    }
}

fun main() {
    println(PermutationString().checkInclusion("ab", "eidbaooo"))
    println(PermutationString().checkInclusion("ab", "eidboaoo"))
    println(PermutationString().checkInclusion("adc", "dcda"))
}