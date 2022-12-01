### 問題19

#### Sealed classes

Reuse your solution from the previous task, but replace the interface with the sealed interface. Then you no longer need the else branch in when.

---
解答例

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

---
知識

シールドクラスは継承をより制限的にしたもの

Enumに似ているが、下記違いあり。

クラスやオブジェクト宣言をクラス内に内包できる

インスタンスを作れる

when式でelseを省くことができる（シールドクラスの中はenum同様、宣言時に書いたものに限られているので、全ての可能性はシールドクラスの中身に限られているため。）
