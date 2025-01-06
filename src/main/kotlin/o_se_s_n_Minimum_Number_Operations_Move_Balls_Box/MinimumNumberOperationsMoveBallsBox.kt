package o_se_s_n_Minimum_Number_Operations_Move_Balls_Box

import kotlin.math.abs

class MinimumNumberOperationsMoveBallsBox {
    fun minOperations2(boxes: String): IntArray {
        val result = IntArray(boxes.length)

        for (i in boxes.indices) {
            for (j in boxes.indices) {
                if (i != j && boxes[j] == '1') result[i] += abs(j - i)
            }
        }

        return result
    }

    fun minOperations(boxes: String): IntArray {
        val right = IntArray(boxes.length)
        val left = IntArray(boxes.length)
        var count = 0
        var leftSum = 0

        for (i in boxes.lastIndex - 1 downTo 0) {
            if (boxes[i + 1] == '1') count++
            right[i] = right[i + 1] + count
        }

        count = 0
        left[0] = right[0]

        for (i in 1 .. boxes.lastIndex) {
            if (boxes[i - 1] == '1') count++
            leftSum += count
            left[i] = leftSum + right[i]
        }

        return left
    }
}

fun main() {
    var res = MinimumNumberOperationsMoveBallsBox().minOperations("110")
    res.forEach { print("$it, ") }
    println()
}