package o_f_s_t_Course_ScheduleIV

class CourseScheduleIV {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        val result = mutableListOf<Boolean>()
        val map = HashMap<Int, MutableList<Int>>()

        for (i in prerequisites.indices) {
            map.computeIfAbsent(prerequisites[i][0], {k -> mutableListOf() })
                .add(prerequisites[i][1])
        }

        for (i in queries.indices) {
            val visited = BooleanArray(numCourses)
            result.add(isPrerequisites(map, visited, queries[i][0], queries[i][1]))
        }

        return result
    }

    fun isPrerequisites(map: HashMap<Int, MutableList<Int>>,
                        visited: BooleanArray, cur: Int, target: Int) : Boolean {
        var answer = false
        visited[cur] = true

        if (cur == target) return true

        val neighbors = map[cur]

        if (neighbors != null) {
            for (i in neighbors.indices) {
                if (!visited[neighbors[i]])
                    answer = answer || isPrerequisites(map, visited, neighbors[i], target)
            }
        }

        return answer
    }
}

fun main() {
    val r = CourseScheduleIV().checkIfPrerequisite(
        5, arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
        ), arrayOf(
            intArrayOf(0, 4),
            intArrayOf(4, 0),
            intArrayOf(1, 3),
            intArrayOf(3, 0),
        )
    )

    r.forEach { print("$it, ") }
}