### 問題4

整数 n が与えられるので、 n 回、改行区切りで Hello World! と出力してください。
入力される値
入力は以下のフォーマットで与えられます。

n

整数 n が 1 行で与えられます。

入力値最終行の末尾に改行が１つ入ります。
文字列は標準入力から渡されます。 標準入力からの値取得方法はこちらをご確認ください
期待する出力
n 回 Hello World! と改行区切りで出力してください。

Hello World!
...
Hello World!

末尾に改行を入れ、余計な文字、空行を含んではいけません。
条件
すべてのテストケースにおいて、以下の条件をみたします。

・1 ≦ n ≦ 50

---
    入力例1
    2
    
    出力例1
    Hello World!
    Hello World!

---

    入力例2
    5
    
    出力例2
    Hello World!
    Hello World!
    Hello World!
    Hello World!

---

    解答例
    
    fun main() {
    val n = readLine()!!.toInt()
    val s = "Hello World!"
    for(i in 1..n) {
    println(s)
    }
    }

