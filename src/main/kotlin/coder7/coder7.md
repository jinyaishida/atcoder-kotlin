### 問題7 

整数 n が与えられるので、n 回、半角スペース区切りで Hello World! と出力してください。

入力される値
入力は以下のフォーマットで与えられます。

n

1行目に整数nが与えられます。

入力値最終行の末尾に改行が１つ入ります。
文字列は標準入力から渡されます。 標準入力からの値取得方法はこちらをご確認ください
期待する出力
Hello World! と n 回、半角スペース区切りで出力してください。最後の Hello World! の後には半角スペースは入れず、改行を入れ、余計な文字、空行を含んではいけません。

Hello World! Hello World! ... Hello World!
条件
すべてのテストケースにおいて、以下の条件をみたします。

・1 ≦ n ≦ 50

---
    入力例1
    2
    
    出力例1
    Hello World! Hello World!
---
    入力例2
    3
    
    出力例2
    Hello World! Hello World! Hello World!
---
    解答例
    fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val s = "Hello World!"
    for(i in 1..n) {
    print("$s ")
    }
    println()
    }