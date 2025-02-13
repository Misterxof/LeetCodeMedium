package th_z_s_s_Minimum_Operations_Exceed_Threshold_ValueII

import java.util.Comparator
import java.util.PriorityQueue
import kotlin.math.max

class MinimumOperationsExceedThresholdValueII {
    fun minOperations(nums: IntArray, k: Int): Int {
        val queue: PriorityQueue<Long> = PriorityQueue<Long> { o1, o2 -> o1.compareTo(o2) }
        var result = 0

        queue.addAll(nums.map { it.toLong() })

        while (queue.size > 1 && queue.peek() < k) {
            val x = queue.poll()
            val y = queue.poll()
            queue.add(minOf(x, y) * 2 + maxOf(x, y))
            result++
        }

        return result
    }
}