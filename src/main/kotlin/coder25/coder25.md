### 問題25

Operators overloading

Implement date arithmetic and support adding years, weeks, and days to a date. You could write the code like this: date + YEAR * 2 + WEEK * 3 + DAY * 15.
First, add the extension function plus() to MyDate, taking the TimeInterval as an argument. Use the utility function MyDate.addTimeIntervals() declared in DateUtil.kt
Then, try to support adding several time intervals to a date. You may need an extra class.
---

解答例


    data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)
    
    // Supported intervals that might be added to dates:
    enum class TimeInterval { DAY, WEEK, YEAR }
    
    operator fun MyDate.plus(timeInterval: TimeInterval) =
    addTimeIntervals(timeInterval, 1)
    
    class RepeatedTimeInterval(val timeInterval: TimeInterval, val number: Int)
    
    operator fun TimeInterval.times(number: Int) =
    RepeatedTimeInterval(this, number)
    
    operator fun MyDate.plus(timeIntervals: RepeatedTimeInterval) =
    addTimeIntervals(timeIntervals.timeInterval, timeIntervals.number)
    
    fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
    }
    
    fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
    }

---

知識

自分で作ったクラスなどで演算子をオーバーロードすると
+、-、*、/などの演算子をそのクラスのインスタンスに使用することができるようになる

a+bやa-bのように、二つの値を計算させる時に使う演算子が二項演算子

Kotlinで二項演算子をオーバーライドするには
以下の表で対応している関数をオーバーライドすることで、
その演算子が独自クラスでも機能するようになる

二項演算子の対応リスト

式	コンパイル時に使われる関数

    a + b	a.plus(b)
    a - b	a.minus(b)
    a * b	a.times(b)
    a / b	a.div(b)
    a % b	a.rem(b), a.mod(b) (非推奨)
    a..b	a.rangeTo(b)
