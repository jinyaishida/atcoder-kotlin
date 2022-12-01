### 問題24

For loop

A Kotlin for loop can iterate through any object if the corresponding iterator member or extension function is available.
Make the class DateRange implement Iterable<MyDate>, so that it can be iterated over. Use the function MyDate.followingDate() defined in DateUtil.kt; you don't have to implement the logic for finding the following date on your own.
Use an object expression which plays the same role in Kotlin as an anonymous class in Java.

---

解答例

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

---

知識

イテレーターはforループが動作するために必要な概念

イテレーターが実装されていないオブジェクトではforループは不可

イテレーターとは、

次の要素を返すnext()メソッドと

次の要素が存在するかを確かめるhasNext()メソッドの二つで成り立っている。

この二つによって、forループがいつまで繰り返されるべきなのかを知ることができる

イテレーターを実装するには、クラスの中でiterator()関数をオーバーライドし、
その関数内で次の値を返すnext()と、次の値の有無をチェックするhasNext()を実装する必要がある。

