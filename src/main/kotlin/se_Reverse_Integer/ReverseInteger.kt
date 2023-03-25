package se_Reverse_Integer

class ReverseInteger {
    fun reverse(x: Int): Int {
        var x = x
        var result = 0

        while (x != 0) {
            if (result * 10 / 10 == result) {
                result = (result * 10) + x % 10
                x /= 10
            } else return 0
        }

        return result
    }
}

fun main() {
    println(ReverseInteger().reverse(1534236469))
}