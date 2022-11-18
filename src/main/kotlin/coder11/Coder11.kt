package coder11

class Coder11 {
    fun main(args: Array<String>) {
        val question = "life, the universe, and everything"
        val answer = 42

        val tripleQuotedString = """
    #question = "$question"
    #answer = $answer""".trimMargin("#")

        fun main() {
            println(tripleQuotedString)
        }
    }
}