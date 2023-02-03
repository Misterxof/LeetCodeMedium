package s_Zigzag_Conversion

class ZigzagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s

        val resAr: Array<String> = Array(numRows) { "" }
        var result = ""
        val sar: CharArray = s.toCharArray()
        var row = 0
        val diag = numRows - 2
        var position = 0
        var curStep = numRows + diag
        var step = numRows + diag
        var curDiag = diag
        var i = 0
        var isDiag = false

        while (i < s.length) {

            if ((position % numRows == 0 && position == numRows) && numRows != 2 ||
                position % (numRows + curStep) == 0 && position != 0 && numRows != 2 || isDiag) {
                if (position != numRows && !isDiag) curStep += step

                if (curDiag > 0) {
                    isDiag = true
                    resAr[curDiag] += sar[i].toString()
                    position++
                    i++
                    curDiag--
                }

                if (curDiag == 0) {
                    curDiag = diag
                    isDiag = false
                }

            } else {
                if (row == numRows) row = 0
                if (row < numRows) {
                    resAr[row] += sar[i].toString()
                    row++
                    position++
                    i++
                }
            }
        }

        resAr.forEach {
           result += it
        }
        return result
    }
}

fun main() {
    println(ZigzagConversion().convert("PAYPALISHIRING", 3))
    println()
    println(ZigzagConversion().convert("PAYPALISHIRING", 4))
    println()
    println(ZigzagConversion().convert("ABC", 2))
    println()
    println(ZigzagConversion().convert("ABCD", 2))
    println()
    println(ZigzagConversion().convert("ABCDEF", 5))
    println()
    println(ZigzagConversion().convert("Apalindromeisaword,phrase,number,orothersequenceo" +
            "funitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustme" +
            "ntstopunctuationandworddividers.v", 3))
}