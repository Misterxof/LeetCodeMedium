package o_o_f_th_Longest_Common_Subsequence

class LongestCommonSubsequence {
    fun longestCommonSubsequence2(text1: String, text2: String): Int {
        return dp(text1, text2, text1.length - 1, text2.length - 1)
    }

    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val dp = Array(text1.length + 1) { IntArray(text2.length + 1) }

        for (i in text1.indices.reversed()) {
            for (j in text2.indices.reversed()) {
                dp[i][j] = if (text1[i] == text2[j]) {
                    1 + dp[i + 1][j + 1]
                } else {
                    maxOf(dp[i + 1][j], dp[i][j + 1])
                }
            }
        }

        return dp[0][0]
    }

    fun dp(text1: String, text2: String, i: Int, j: Int): Int {
        if (i == 0 || j == 0) return 0

        if (text1[i] == text2[j]) return dp(text1, text2, i - 1, j - 1) + 1
        else return maxOf(dp(text1, text2, i, j - 1), dp(text1, text2, i - 1, j))
    }
}

fun main() {
    println(LongestCommonSubsequence().longestCommonSubsequence(
        "mhunuzqrkzsnidwbun",
        "szulspmhwpazoxijwbq"
    ))
}