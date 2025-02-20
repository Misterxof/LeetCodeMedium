package o_n_e_z_Find_Unique_Binary_String

class FindUniqueBinaryString {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val set = HashSet<String>()

        findUnique(StringBuilder("0"), nums[0].length - 1, set, nums)
        findUnique(StringBuilder("1"), nums[0].length - 1, set, nums)

        return set.first()
    }

    fun findUnique(str: StringBuilder, n: Int, set: HashSet<String>, nums: Array<String>) {
        if (set.size >= 1) return

        if (n == 0 && !nums.contains(str.toString())) {
            set.add(str.toString())
            return
        } else if (n == 0) return

        findUnique(StringBuilder(str.toString() + '0'), n - 1, set, nums)
        findUnique(StringBuilder(str.toString() + '1'), n - 1, set, nums)
    }
}

fun main() {
    println(FindUniqueBinaryString().findDifferentBinaryString(arrayOf("01","10")))
}