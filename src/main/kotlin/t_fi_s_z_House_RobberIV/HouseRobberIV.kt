package t_fi_s_z_House_RobberIV

class HouseRobberIV {
    fun minCapability(nums: IntArray, k: Int): Int {
        var min = 0
        var max = nums.max()
        var i = 0

        while (min < max) {
            var count = 0
            val middle = (min + max) / 2
            
            while (i < nums.size) {
                if (nums[i] <= middle) {
                    count++
                    i++
                }
                i++
            }

            if (count >= k) max = middle
            else min = middle + 1
        }

        return min
    }
}