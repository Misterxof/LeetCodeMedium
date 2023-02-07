package n_z_f_Fruit_Into_Baskets

class FruitIntoBaskets {
    fun totalFruit(fruits: IntArray): Int {
        if (fruits.size <= 2) return fruits.size

        var firstType = -1
        var secondType = -1
        var max = 0
        var curMax = 0
        var lastIndex = 0
        var index = 0
        val upd = {
            curMax++
            index++
            max = maxOf(max, curMax)
        }

        while (index <= fruits.size - 1) {
            if (index == 0){
                firstType = fruits[0]
                upd()
                continue
            }

            if (fruits[index] == firstType || fruits[index] == secondType || secondType == -1) {
                if (fruits[index] == firstType || fruits[index] == secondType) {
                    upd()
                    continue
                } else {
                    secondType = fruits[index]
                    lastIndex = index
                    upd()
                    continue
                }
            } else {
                max = maxOf(max, curMax)
                firstType = secondType
                curMax = 0
                secondType = -1
                index = lastIndex
            }
        }

        return max
    }
}

fun main() {
    println(FruitIntoBaskets().totalFruit(intArrayOf(1,2,3,2,2)))
    println(FruitIntoBaskets().totalFruit(intArrayOf(0,1,2,2)))
    println(FruitIntoBaskets().totalFruit(intArrayOf(1,2,1)))
}