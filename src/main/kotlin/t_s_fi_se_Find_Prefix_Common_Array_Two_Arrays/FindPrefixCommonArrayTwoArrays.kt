package t_s_fi_se_Find_Prefix_Common_Array_Two_Arrays

class FindPrefixCommonArrayTwoArrays {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val result = IntArray(A.size)
        val counts = IntArray(50)
        var counter = 0

        for (i in A.indices) {
            counts[A[i] - 1] += 1
            counts[B[i] - 1] += 1

            if (A[i] == B[i]) counter++
            else {
                if (counts[A[i] - 1] == 2) counter++
                if (counts[B[i] - 1] == 2) counter++
            }

            result[i] = counter
        }

        return result
    }
}