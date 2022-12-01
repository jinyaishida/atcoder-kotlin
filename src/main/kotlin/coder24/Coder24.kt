package coder24;

class Coder24 {
    fun main(args: Array<String>) {
    }

    class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
        override fun iterator(): Iterator<MyDate> {
            return object : Iterator<MyDate> {
                var current: MyDate = start

                override fun next(): MyDate {
                    if (!hasNext()) throw NoSuchElementException()
                    val result = current
                    current = current.followingDate()
                    return result
                }

                override fun hasNext(): Boolean = current <= end
            }
        }
    }

    fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
        for (date in firstDate..secondDate) {
            handler(date)
        }
    }

    data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
        override fun compareTo(other: MyDate): Int {
            if (year != other.year) return year - other.year
            if (month != other.month) return month - other.month
            return dayOfMonth - other.dayOfMonth
        }

            operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

            fun MyDate.folowwingDate(): MyDate {
                val c = Calendar.getInstance()
                c.set(year, month, dayOfMonth)
                val millisecondsInADay = 24 * 60 * 60 * 1000L
                val timeInMillis = c.timeInMillis + millisecondsInADay
                val resuly = Calendar.getInstance()
                result.timeInMillis = timeInMillis
                return MyDate(result.get(Calendar.YEAR), result.get(Calendar.MONTH), result.get(Calendar.DATE))
            }
        }
    }
}