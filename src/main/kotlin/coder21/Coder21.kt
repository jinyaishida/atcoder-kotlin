package coder21

class Coder21 {
    fun main(args: Array<String>) {
        fun Int.r(): RationalNumber = RationalNumber(this, 1)

        fun Pair<Int, Int>.r(): RationalNumber = RationalNumber(first, second)

    }
    data class RationalNumber(val numerator: Int, val denominator: Int)
    }
