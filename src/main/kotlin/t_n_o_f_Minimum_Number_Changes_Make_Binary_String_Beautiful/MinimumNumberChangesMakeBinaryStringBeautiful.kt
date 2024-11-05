package t_n_o_f_Minimum_Number_Changes_Make_Binary_String_Beautiful

class MinimumNumberChangesMakeBinaryStringBeautiful {
    fun minChanges(s: String): Int {
        var count = 0

        for(i in s.indices step 2) {
            if (i + 1 < s.length && s[i] != s[i + 1]) count++
        }

        return count
    }
}