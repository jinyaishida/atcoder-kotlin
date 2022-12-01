### 問題23

Ranges

Using ranges implement a function that checks whether the date is in the range between the first date and the last date (inclusive).
You can build a range of any comparable elements. In Kotlin in checks are translated to the corresponding contains calls and .. to rangeTo calls:

    val list = listOf("a", "b")
    "a" in list  // list.contains("a")
    "a" !in list // !list.contains("a")
    ​
    date1..date2 // date1.rangeTo(date2)

---
解答例

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

---
知識

kotolinでは、

in  = contains
.. = rangeTo

で表すことができる

---
例

    iが1から4の間

---

    1 <= i && i <= 4
---

    if (i in 1..4) {  
    print(i)
    }

---

    i in 1.rangeTo(4)
---

    if ((1..4).contains(i)) {
    print(i)
    }