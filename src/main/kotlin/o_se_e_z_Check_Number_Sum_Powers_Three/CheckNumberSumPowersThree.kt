package o_se_e_z_Check_Number_Sum_Powers_Three

class CheckNumberSumPowersThree {
    fun checkPowersOfThree(n: Int): Boolean {
        var n = n

        while(n != 0) {
            if (n % 3 == 2) return false
            n /= 3
        }

        return true
    }
}