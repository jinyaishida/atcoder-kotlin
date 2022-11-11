package coder6

class Coder6 {
    fun main(args: Array<String>) {
        val count = readLine()!!.toInt()

        for (i in 1 .. count) {
            val message = readLine()
            println(message?.maxOrNull())
        }
    }
}
