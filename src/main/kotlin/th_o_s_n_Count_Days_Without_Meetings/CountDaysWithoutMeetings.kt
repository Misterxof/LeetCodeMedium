package th_o_s_n_Count_Days_Without_Meetings

class CountDaysWithoutMeetings {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        val sm = meetings.sortedBy { (s,e) -> s }
        var end = 0
        var result = 0

        for ((s, e) in sm) {
            result += maxOf(0, s - end - 1)
            end += maxOf(end, e)
        }
        result += maxOf(0, days - end)

        return result
    }
}