package th_o_th_th_Minimum_Array_End

class MinimumArrayEnd {
    fun minEnd(n: Int, x: Int): Long {
        var r = x.toLong()
        var i = 1L
        var j = 1L

        while(i < Long.MAX_VALUE / 2) {
            if (r and i == 0L) {
                if ((n - 1).toLong() and j != 0L) r = r or i
                j = j shl 1
            }
            i = i shl 1
        }

        // for(i in 0..Int.MAX_VALUE) {
        //     if (j == n) break
        //     if (res[0] == 0L && (i and max) == x)
        //         res[j++] = i.toLong()
        //     else if(j - 1 >= 0 && (i and res[j - 1].toInt()) == x)
        //         res[j++] = i.toLong()
        // }

        return r
    }
}