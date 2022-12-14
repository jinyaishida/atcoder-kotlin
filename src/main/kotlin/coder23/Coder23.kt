package coder23

class Coder23 {
    fun main(args: Array<String>) {
        fun checkInRange(date: MyDate, first: MyDate, last: MyDate): Boolean {
            return date in first..last
        }
    }

    data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
        override fun compareTo(other: MyDate): Int {
            if (year != other.year) return year - other.year
            if (month != other.month) return month - other.month
            return dayOfMonth - other.dayOfMonth
        }
    }
}