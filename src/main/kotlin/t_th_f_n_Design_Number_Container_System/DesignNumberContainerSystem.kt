package t_th_f_n_Design_Number_Container_System

import java.util.TreeSet

class DesignNumberContainerSystem {
    val map = HashMap<Int, TreeSet<Int>>()
    val indices = HashMap<Int, Int>()

    fun change(index: Int, number: Int) {
        if (indices.contains(index)) {
            map[indices[index]]?.remove(index)
        }
        map[number] = map.getOrDefault(number, TreeSet()).apply {
            add(index)
        }
        indices[index] = number
    }

    fun find(number: Int): Int {
        return map[number]?.firstOrNull() ?: -1
    }
}