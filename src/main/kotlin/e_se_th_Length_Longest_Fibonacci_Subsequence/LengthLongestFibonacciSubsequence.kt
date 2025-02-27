package e_se_th_Length_Longest_Fibonacci_Subsequence

class LengthLongestFibonacciSubsequence {
    fun lenLongestFibSubseq(arr: IntArray): Int {
        val set = HashSet<Int>()
        var max = 0

        arr.forEach { set.add(it) }

        for (i in 0 until arr.lastIndex - 1) {
            for (j in i + 1..arr.lastIndex) {
                val c = fib(set, arr[i], arr[j])
                if (c != 0) max = maxOf(max, c + 2)
            }
        }

        return max
    }

    fun fib(set: HashSet<Int>, a: Int, b:Int): Int {
        return when {
            set.contains(a + b) -> 1 + fib(set, b, a + b)
            else -> 0
        }
    }
}

fun main() {
    println(LengthLongestFibonacciSubsequence().lenLongestFibSubseq(intArrayOf(1,2,3,4,5,6,7,8)))
}