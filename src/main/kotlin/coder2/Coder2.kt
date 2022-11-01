package coder2

class Coder2 {
    fun main(args: Array<String>) {
        val (a, b, c) = readLine()!!.split("").map(String::toInt)
        val s = readLine()!!.split("").map { }
        println((a + b + c).toString() + " " + s)
    }
}

