### 問題9

Make the function joinOptions() return the list in a JSON format (for example, [a, b, c]) by specifying only two arguments.
Default and named arguments help to minimize the number of overloads and improve the readability of the function invocation. The library function joinToString is declared with default values for parameters:
    
    fun joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    /* ... */
    ): String
It can be called on a collection of Strings.

---
    解答例
    fun main(args: Array<String>) {
    fun joinOptions(
    options: Collection<String>) =
    options.joinToString(
    prefix ="[", postfix = "]"
    )
    
    print(joinOptions(listOf("a", "b")))
    }