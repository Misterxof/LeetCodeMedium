package t_f_t_fi_BitwiseXOR_All_Pairings

class BitwiseXORAllPairings {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        var xor1 = 0
        var xor2 = 0

        if(nums1.size %2 != 0) {
            for (i in nums1.indices)
                xor1 = xor1 xor nums1[i]
        }

        if(nums2.size %2 != 0) {
            for (i in nums2.indices)
                xor2 = xor2 xor nums2[i]
        }

        return xor1 xor xor2
    }
}