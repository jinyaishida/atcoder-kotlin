### 問題15

Kotlin supports functional programming. Learn about lambdas in Kotlin.
Pass a lambda to the any function to check if the collection contains an even number. The any function gets a predicate as an argument and returns true if at least one element satisfies the predicate.

---
解答例

    fun main(args: Array<String>) {
    fun containsEven(collection: Collection<Int>): Boolean =
    collection.any { i -> i % 2 == 0 }
    }

---
知識

Kotlinのラムダ式の書き方

    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

ラムダ式は常に中括弧｛｝で囲まれる
パラメーター宣言は中括弧内で行われ、
任意で型のアノテーションをつけることができる。（x: Intにおける: Int）
ラムダ式のボディ部分は->の後にくる。
もし推論されるラムダ式の戻り値の型がUnitでなければ、
ボディの最後の式（一行のみの場合も）が戻り値として扱われる。

偶数が含まれているかをチェックするためには 

    i % 2 == 0

のように、２で割った時に０になるようにすればOK

参考
https://maku77.github.io/kotlin/basic/lambda.html


