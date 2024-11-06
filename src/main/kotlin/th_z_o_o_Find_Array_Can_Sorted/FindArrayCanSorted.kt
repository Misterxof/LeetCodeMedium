package th_z_o_o_Find_Array_Can_Sorted

class FindArrayCanSorted {
    fun canSortArray(nums: IntArray): Boolean {

        out@ for (i in nums.indices) {
            loop@ for (j in 0 until nums.lastIndex - i) {
                if (nums[j] > nums[j + 1]) {
                    if (nums[j].countOneBits() == nums[j + 1].countOneBits()) {
                        nums[j] = nums[j + 1].also { nums[j + 1] = nums[j] }
                        continue@loop
                    } else return false
                }
            }
        }

        return true
    }
}

fun main() {
//    val i = 2
//    val w = 4
//    println(i.countOneBits())
//    println(w.countOneBits())
    println(FindArrayCanSorted().canSortArray(intArrayOf(8,4,2,30,15)))
    println(FindArrayCanSorted().canSortArray(intArrayOf(1,2,3,4,5)))
    println(FindArrayCanSorted().canSortArray(intArrayOf(3,16,8,4,2)))
}