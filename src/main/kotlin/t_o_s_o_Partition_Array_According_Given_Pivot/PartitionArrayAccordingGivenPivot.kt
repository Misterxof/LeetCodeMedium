package t_o_s_o_Partition_Array_According_Given_Pivot

class PartitionArrayAccordingGivenPivot {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val before = mutableListOf<Int>()
        val after = mutableListOf<Int>()
        var count = 0

        nums.forEach {
            if (it < pivot) before.add(it)
            else if (it > pivot) after.add(it)
            else count++
        }

        repeat(count) {
            before.add(pivot)
        }

        before.addAll(after)

        return before.toIntArray()
    }
}