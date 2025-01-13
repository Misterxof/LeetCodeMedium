package th_t_t_th_Minimum_Length_String_Operations

class MinimumLengthStringOperations {
    fun minimumLength(s: String): Int {
        val lattesArray = IntArray(26)
        var result = 0

        s.forEach {
            lattesArray[it - 'a'] += 1
        }

        lattesArray.forEach {
            if (it >= 3) {
                var res = it
                while (res >= 3){
                    res = res / 3 + (res - (res / 3) * 3)
                }

                println("$it s ${res}")
                result += res
            } else {
                println("$it s $it")
                result += it
            }
        }

        return result
    }
}

fun main() {
    println(MinimumLengthStringOperations().minimumLength("ucvbutgkohgbcobqeyqwppbxqoynxeuuzouyvmydfhrprdbuzwqebwuiejoxsxdhbmuaiscalnteocghnlisxxawxgcjloevrdcj"))
}