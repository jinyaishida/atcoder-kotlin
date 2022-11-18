### 問題14


Nothing type can be used as a return type for a function that always throws an exception. When you call such a function, the compiler uses the information that the execution doesn't continue beyond the function.
Specify Nothing return type for the failWithWrongAge function. Note that without the Nothing type, the checkAge function doesn't compile because the compiler assumes the age can be null.

---

解答例

    fun main(args: Array<String>) {
    fun failWithWrongAge(age: Int?):Nothing {
    throw IllegalArgumentException("Wrong age: $age")
    }
    
    fun checkAge(age: Int?) {
        if (age == null || age !in 0..150) failWithWrongAge(age)
        println("Congrats! Next year you'll be ${age + 1}.")
    }
    
    fun main() {
        checkAge(10)
    }

---

知識

    Nothing 型は特殊な型
    すべての Kotlin におけるクラスのサブクラスを表す
    
    使い道の例
    常に例外をスローする関数の戻り値の型として使用できる
    絶対に正常終了することのない関数の戻り値として使い、値が存在しないことを表す
    インスタンスを返さず、nullにもなり得ないという性質のため、
    例外を送り出するような関数をnull許容型を使わずに実装することが可能