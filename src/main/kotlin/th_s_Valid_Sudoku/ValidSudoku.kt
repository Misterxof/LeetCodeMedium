package th_s_Valid_Sudoku

class ValidSudoku {

    // Can use Set, add() returns false on duplicate
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val result: Array<HashMap<Int, MutableList<Int>>> = Array(9 * 3){ hashMapOf() }// hashMapOf<Int, MutableList<Int>>() for LeetCode

        board.forEachIndexed { i, it ->
            it.forEachIndexed row@ { j, jt ->
                if (jt == '.') return@row
                else {
                    val jt = jt.digitToInt()    // toInt() for LeetCode
                    if (result[i]!!.contains(jt)) return false
                    if (result[j+9]!!.contains(jt)) return false
                    result[i][jt] = mutableListOf(jt)   // rows
                    result[j+9][jt] = mutableListOf(jt) // columns
                    // for 3x3 boxes
                    when {
                        i in 0..2 && j in 0..2-> {
                            if (result[18]!!.contains(jt)) return false
                            result[18][jt] = mutableListOf(jt)
                        }
                        i in 0..2 && j in 3..5-> {
                            if (result[19]!!.contains(jt)) return false
                            result[19][jt] = mutableListOf(jt)
                        }
                        i in 0..2 && j in 6..8-> {
                            if (result[20]!!.contains(jt)) return false
                            result[20][jt] = mutableListOf(jt)
                        }
                        i in 3..5 && j in 0..2 -> {
                            if (result[21]!!.contains(jt)) return false
                            result[21][jt] = mutableListOf(jt)
                        }
                        i in 3..5 && j in 3..5-> {
                            if (result[22]!!.contains(jt)) return false
                            result[22][jt] = mutableListOf(jt)
                        }
                        i in 3..5 && j in 6..8-> {
                            if (result[23]!!.contains(jt)) return false
                            result[23][jt] = mutableListOf(jt)
                        }
                        i in 6..8 && j in 0..2-> {
                            if (result[24]!!.contains(jt)) return false
                            result[24][jt] = mutableListOf(jt)
                        }
                        i in 6..8 && j in 3..5-> {
                            if (result[25]!!.contains(jt)) return false
                            result[25][jt] = mutableListOf(jt)
                        }
                        i in 6..8 && j in 6..8-> {
                            if (result[26]!!.contains(jt)) return false
                            result[26][jt] = mutableListOf(jt)
                        }
                    }
                }
            }
        }
        return true
    }
}

fun main() {
    var res = ValidSudoku().isValidSudoku(arrayOf(
        charArrayOf('5','3','.','.','7','.','.','.','.'),
        charArrayOf('6','.','.','1','9','5','.','.','.'),
        charArrayOf('.','9','8','.','.','.','.','6','.'),
        charArrayOf('8','.','.','.','6','.','.','.','3'),
        charArrayOf('4','.','.','8','.','3','.','.','1'),
        charArrayOf('7','.','.','.','2','.','.','.','6'),
        charArrayOf('.','6','.','.','.','.','2','8','.'),
        charArrayOf('.','.','.','4','1','9','.','.','5'),
        charArrayOf('.','.','.','.','8','.','.','7','9')
    ))
    println(res)
    res = ValidSudoku().isValidSudoku(arrayOf(
        charArrayOf('8','3','.','.','7','.','.','.','.'),
        charArrayOf('6','.','.','1','9','5','.','.','.'),
        charArrayOf('.','9','8','.','.','.','.','6','.'),
        charArrayOf('8','.','.','.','6','.','.','.','3'),
        charArrayOf('4','.','.','8','.','3','.','.','1'),
        charArrayOf('7','.','.','.','2','.','.','.','6'),
        charArrayOf('.','6','.','.','.','.','2','8','.'),
        charArrayOf('.','.','.','4','1','9','.','.','5'),
        charArrayOf('.','.','.','.','8','.','.','7','9')
    ))
    println(res)
    res = ValidSudoku().isValidSudoku(arrayOf(
        charArrayOf('.','.','4','.','.','.','6','3','.'),
        charArrayOf('.','.','.','.','.','.','.','.','.'),
        charArrayOf('5','.','.','.','.','.','.','9','.'),
        charArrayOf('.','.','.','5','6','.','.','.','.'),
        charArrayOf('4','.','3','.','.','.','.','.','1'),
        charArrayOf('.','.','.','7','.','.','.','.','.'),
        charArrayOf('.','.','.','5','.','.','.','.','.'),
        charArrayOf('.','.','.','.','.','.','.','.','.'),
        charArrayOf('.','.','.','.','.','.','.','.','.')
    ))
    println(res)
    res = ValidSudoku().isValidSudoku(arrayOf(
        charArrayOf('.','.','.','.','.','.','5','.','.'),
        charArrayOf('.','.','.','.','.','.','.','.','.'),
        charArrayOf('.','.','.','.','.','.','.','.','.'),
        charArrayOf('9','3','.','.','2','.','4','.','.'),
        charArrayOf('.','.','7','.','.','.','3','.','.'),
        charArrayOf('.','.','.','.','.','.','.','.','.'),
        charArrayOf('.','.','.','3','4','.','.','.','.'),
        charArrayOf('.','.','.','.','.','3','.','.','.'),
        charArrayOf('.','.','.','.','.','5','2','.','.')
    ))
    println(res)
}