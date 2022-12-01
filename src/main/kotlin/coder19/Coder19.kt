package coder19

class Coder19 {
    fun main(args: Array<String>) {
        fun eval(expr: Expr): Int =
            when (expr) {
                is Num -> expr.value
                is Sum -> eval(expr.left) + eval(expr.right)
            }
    }
        sealed class Expr
        data class Num(val value: Int) : Expr()
        data class Sum(val left: Expr, val right: Expr) : Expr()

}