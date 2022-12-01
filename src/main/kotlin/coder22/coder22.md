### 問題22

Comparison

Learn about operator overloading and how the different conventions for operations like ==, <, + work in Kotlin. Add the function compareTo to the class MyDate to make it comparable. After this, the code below date1 < date2 should start to compile.
Note that when you override a member in Kotlin, the override modifier is mandatory.

---
解答例

    fun main(args: Array<String>) {
        data class MyDate(
            val year: Int,
            val month: Int,
            val dayOfMonth: Int
        ) : Comparable<MyDate> {
            override fun compareTo(
            other: MyDate
            ) = when {
                year != other.year -> year - other.year
                month != other.month -> month - other.month
                else -> dayOfMonth - other.dayOfMonth
            }
        }

        fun test(date1: MyDate, date2: MyDate) {
            // this code should compile:
            println(date1 < date2)
        }
    }

---
知識

yearが異なればyearからother.yearを引いた値を返す

yearの値とother.yearの値が同じ場合はmonth

もし、date1.year < date2.yearであれば
date1.compareTo(date2)で返ってくる値は負（<0）になるため、
date1.compareTo(date2) < 0はtrueを返す

よって、date1 < date2もtrue