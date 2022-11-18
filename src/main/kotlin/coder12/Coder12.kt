package coder12

class Coder12 {
    fun main(args: Array<String>) {
        val month = "(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)"

        fun getPattern(): String = """\d{2}\ $month \d{4}"""
    }
}