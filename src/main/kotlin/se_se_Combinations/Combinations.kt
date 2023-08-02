package se_se_Combinations

class Combinations {
    val result = mutableListOf<List<Int>>()
    fun combine(n: Int, k: Int): List<List<Int>> {
        var i = 1

        while (i <= n - k + 1) {
            combineAll(i, k, n, i + 1, "$i", 1)
            i++
        }
        
        return result
    }

    private fun combineAll(r: Int, k: Int, n: Int, rNext: Int, res: String, iteration: Int) {
        var rNext = rNext

        if (iteration < k) {
            while (rNext <= n) {
                combineAll(r, k, n, rNext + 1, "$res,$rNext", iteration + 1)
                rNext++
            }
        } else {
            result.add(res.split(",").map { it.toString().toInt() })
        }
    }
}

fun main() {
    //println(Combinations().combine(5, 3))
    //println(Combinations().combine(4, 2))
//    println(Combinations().combine(10, 7))
    println(Combinations().combine(13, 3))
}