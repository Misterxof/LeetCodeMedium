package o_s_se_Two_Sum_Sorted

class TwoSumSorted {

    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var startPointer = 0
        var endPointer= numbers.lastIndex

        while (true) {
            if (numbers[startPointer] + numbers[endPointer] == target) break
            if (numbers[startPointer] + numbers[endPointer] > target) endPointer--
            else startPointer++
        }

        return intArrayOf(startPointer + 1, endPointer + 1)
    }

    fun twoSum2(numbers: IntArray, target: Int): IntArray {
        var startPointer = 0
        var endPointer: Int
        var i = 1

        while (true) {
            if (i >= numbers.size || (numbers[i] > target && target > 0) || (numbers[i] < target && target < 0)) {
                startPointer++
                i = startPointer + 1
                continue
            }
            if (numbers[startPointer] + numbers[i] == target) {
                endPointer = i
                break
            }
            i++
        }

        return intArrayOf(startPointer + 1, endPointer + 1)
    }
}

fun main() {
    println(TwoSumSorted().twoSum(intArrayOf(2,7,11,15), 9).joinToString())
    println(TwoSumSorted().twoSum(intArrayOf(2,3,4), 6).joinToString())
    println(TwoSumSorted().twoSum(intArrayOf(-1,0), -1).joinToString())
    println(TwoSumSorted().twoSum(intArrayOf(0,0,3,4), 0).joinToString())
}