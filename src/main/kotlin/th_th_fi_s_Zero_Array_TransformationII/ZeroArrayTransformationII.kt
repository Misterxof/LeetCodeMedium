package th_th_fi_s_Zero_Array_TransformationII

class ZeroArrayTransformationII {
    fun minZeroArray(nums: IntArray, queries: Array<IntArray>): Int {
        var left = 0
        var right = nums.size

        if (!isAllZeros(nums, queries, queries.size)) return -1

        while (left <= right) {
            val middle = left + (right - left) / 2

            if (isAllZeros(nums, queries, middle)) right = middle - 1
            else left = middle + 1
        }

        return left
    }

    fun isAllZeros(nums: IntArray, queries: Array<IntArray>, k: Int): Boolean {
        val differenceArray = IntArray(nums.size + 1)
        var sum = 0

        for (i in 0 until k) {
            differenceArray[queries[i][0]] += queries[i][2]
            differenceArray[queries[i][1] + 1] -= queries[i][2]
        }

        for (i in nums.indices) {
            sum += differenceArray[i]
            if (sum < nums[i]) return false
        }

        return true
    }
}