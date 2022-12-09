### 問題26

Invoke

Objects with the invoke() method can be invoked as a function.
You can add an invoke extension for any class, but it's better not to overuse it:

    operator fun Int.invoke() { println(this) }
    ​
    1() //huh?..

Implement the function Invokable.invoke() to count the number of times it is invoked.

---

解答例


    class Invokable {
        var numberOfInvocations: Int = 0
            private set

        operator fun invoke(): Invokable {
            numberOfInvocations++
            return this
        }
    }

    fun invokeTwice(invokable: Invokable) = invokable()()
}

---

知識

() だけでメソッドを呼び出だすことができるメソッド
() を繋げて呼び出すこともできる。。が、見た目わかりづらいので使うとコードが読みにくくなる懸念あり。

例

    class Greeter {
    operator fun invoke(name: String) {
    println("Hello $name")
    }
    }

---

    val greeter = Greeter()
    greeter("World")  // `Hello World`と表示されます。

---

    operator fun String.invoke(): String {
    return "$this$this"
    }

---

これはStringを返してるので、 連続使用可能

---

    val a = "Hello"()()()
    println(a) // Helloがたくさん