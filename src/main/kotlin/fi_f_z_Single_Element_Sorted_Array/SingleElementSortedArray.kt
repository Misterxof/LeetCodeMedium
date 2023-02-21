package fi_f_z_Single_Element_Sorted_Array

class SingleElementSortedArray {
    fun singleNonDuplicate(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        var middle = 0

        while (left < right) {
            middle = (left + right) / 2

            if (middle % 2 == 1) middle--

            if (nums[middle] == nums[middle + 1]) left = middle + 2
            else right = middle
        }
        return nums[left]
    }
}

fun main() {
    println(SingleElementSortedArray().singleNonDuplicate(intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)))
}