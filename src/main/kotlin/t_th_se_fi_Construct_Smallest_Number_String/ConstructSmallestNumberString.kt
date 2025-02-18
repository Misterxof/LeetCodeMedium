package t_th_se_fi_Construct_Smallest_Number_String

class ConstructSmallestNumberString {
    fun smallestNumber(pattern: String): String {
        val ans = StringBuilder()
        var left = 0
        var right = 0

        for (p in pattern){
            if (p == 'I'){
                for (num in right+1 downTo left+1){
                    ans.append(num)
                }
                left = right + 1
                right = right + 1
            } else {
                right += 1
            }
        }

        for (num in right+1 downTo left+1){
            ans.append(num)
        }

        return ans.toString()
    }
}

fun main() {
    println(ConstructSmallestNumberString().smallestNumber("DDDIII"))
//    println(ConstructSmallestNumberString().smallestNumber("IIIDIDDD"))
//    println()
//    println(ConstructSmallestNumberString().smallestNumber("DDD"))
}