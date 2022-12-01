### 問題18

Smart casts
Rewrite the following Java code using smart casts and the when expression:

    public int eval(Expr expr) {
    if (expr instanceof Num) {
    return ((Num) expr).getValue();
    }
    if (expr instanceof Sum) {
    Sum sum = (Sum) expr;
    return eval(sum.getLeft()) + eval(sum.getRight());
    }
    throw new IllegalArgumentException("Unknown expression");
    }


---
解答例

    fun eval(expr: Expr): Int =
    when (expr) {
    is Num -> expr.value
    is Sum -> eval(expr.left) + eval(expr.right)
    else -> throw IllegalArgumentException("Unknown expression")
    }
    
    interface Expr
    class Num(val value: Int) : Expr
    class Sum(val left: Expr, val right: Expr) : Expr

---
知識

スマートキャストは、型判定とキャスト（従来のデータ型を別のデータ型に変換すること）が同時に行われる、Kotlinコンパイラの仕組みのこと

kotlinではisを使ってスマートキャストが行われる

例

    fun demo(x: Any) {
    if (x is String) {
    print(x.length) // x は自動的にStringにキャストされてる
    }
    }

右辺の式を正しく評価することも可能

    if (x !is String || x.length == 0) return
    
    if (x is String && x.length > 0) {
    print(x.length)
    }


when式で使うケース

    when (x) {
    is Int -> print(x + 1)
    is String -> print(x.length + 1)
    is IntArray -> print(x.sum())
    }


