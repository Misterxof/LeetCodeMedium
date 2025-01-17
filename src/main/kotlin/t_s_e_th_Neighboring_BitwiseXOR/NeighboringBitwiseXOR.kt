package t_s_e_th_Neighboring_BitwiseXOR

class NeighboringBitwiseXOR {
    fun doesValidArrayExist(derived: IntArray): Boolean {
        var result = 0

        for(i in derived.indices)
            result = result xor derived[i]

        return result == 0
    }
}