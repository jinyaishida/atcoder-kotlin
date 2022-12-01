### 問題21

Extension functions

Learn about extension functions. Then implement the extension functions Int.r() and Pair.r() and make them convert Int and Pair to a RationalNumber.
Pair is a class defined in the standard library

    data class Pair<out A, out B>(
    val first: A,
    val second: B
    )

In the case of Int, the denominator is 1.

---
解答例

    fun main(args: Array<String>) {
        fun Int.r(): RationalNumber = RationalNumber(this, 1)

        fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)
        
    }
    data class RationalNumber(val numerator: Int, val denominator: Int)
    }

---
知識

thisはレシーバーオブジェクト

例：　4.r()      RationalNumber(4, 1)

first　　numerator（分子）
second　　denominator（分母）