package coder9

class Coder9 {
    fun main(args: Array<String>) {
        fun joinOptions(options: Collection<String>) =
            options.joinToString(prefix ="[", postfix = "]")

        print(joinOptions(listOf("a", "b")))
    }
}