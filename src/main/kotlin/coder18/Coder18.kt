package coder18

class Coder18 {

    fun main(args: Array<String>) {

        fun eval(expr: Expr): Int =
            when (expr) {
                is Num -> expr.value
                is Sum -> eval(expr.left) + eval(expr.right)
                else -> throw IllegalArgumentException("Unknown expression")
            }
    }
        interface Expr
        class Num(val value: Int) : Expr
        class Sum(val left: Expr, val right: Expr) : Expr

    }
