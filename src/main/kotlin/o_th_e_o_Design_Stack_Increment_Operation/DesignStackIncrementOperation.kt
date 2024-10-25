package o_th_e_o_Design_Stack_Increment_Operation

import java.util.TreeMap

class DesignStackIncrementOperation(val maxSize: Int) {
    val stack = mutableListOf<Int>()
    var index = -1

    fun push(x: Int) {
        if (index < maxSize - 1) {
            index++
            stack.add(index, x)
        }
    }

    fun pop(): Int {
        if (index == -1) return -1

        val out = stack[index]
        stack.removeAt(index)
        index--
        return out
    }

    fun increment(k: Int, `val`: Int) {
        if (stack.size < k) { stack.forEachIndexed { ind, i -> stack[ind] += `val` }
        } else {
            for (i in 0 until k) stack[i] += `val`
        }
    }
}

fun main() {
    val stack = DesignStackIncrementOperation(3)
    stack.push(1)
    stack.push(2)
    stack.pop()
    stack.push(2)
    stack.push(3)
    stack.push(4)
    stack.increment(5, 100)
    stack.increment(2, 100)
    stack.stack.forEach { print("$it ") }
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
    println(stack.pop())
}