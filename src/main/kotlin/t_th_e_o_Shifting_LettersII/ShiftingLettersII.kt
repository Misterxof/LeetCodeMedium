package t_th_e_o_Shifting_LettersII

class ShiftingLettersII {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val res = CharArray(s.length)
        val shiftArr = IntArray(s.length)

        shifts.forEach {
            for (i in it[0]..it[1]) {
                if (it[2] == 0) shiftArr[i] -= 1
                else shiftArr[i] += 1

                if (shiftArr[i] == 26 || shiftArr[i] == -26) shiftArr[i] = 0
            }
        }

        loop@ for (i in shiftArr.indices) {
            if (shiftArr[i] == 0) {
                res[i] = s[i]
                continue@loop
            }
            else if (shiftArr[i] > 0) {
                var str = s[i] + shiftArr[i]
                if (str > 'z') str -= 26
                res[i] = str
            } else {
                var str = s[i] + shiftArr[i]
                if (str < 'a') str += 26
                res[i] = str
            }
        }

        return res.joinToString("")
    }
}

fun main() {
    println(ShiftingLettersII().shiftingLetters("abc",
        arrayOf(
            intArrayOf(0,1,0),
            intArrayOf(1,2,1),
            intArrayOf(0,2,1)
        )
    ))
    println(ShiftingLettersII().shiftingLetters("dztz",
        arrayOf(
            intArrayOf(0,0,0),
            intArrayOf(1,1,1)
        )
    ))
}