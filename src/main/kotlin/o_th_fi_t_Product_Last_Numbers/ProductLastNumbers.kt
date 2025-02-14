package o_th_fi_t_Product_Last_Numbers

class ProductLastNumbers {
    val list = mutableListOf<Int>().apply{add(1)}
    var size = 0

    fun add(num: Int) {
        if (num == 0) {
            list.clear()
            list.add(1)
            size = 0
        } else list.add(list[size++] * num)
    }

    fun getProduct(k: Int): Int {
        if (k > size) return 0
        else return list[size] / list[size - k]
    }
}

class ProductLastNumbers2 {
    val list = mutableListOf<Int>()

    fun add(num: Int) {
        list.add(num)
    }

    fun getProduct(k: Int): Int {
        var k = k
        var i = list.lastIndex
        var res = list[i--]
        k--

        while (k != 0) {
            if (list[i] == 0) return 0

            res *= list[i--]
            k--
        }

        return res
    }
}