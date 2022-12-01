package coder16

import kotlin.random.Random

class Coder16 {

    fun main(args: Array<String>) {

        val sc = readLine()!!.toInt()
        val n: Int = Random.nextInt(sc)
        var ball = 0
        var strike = 0
                for ( i in 0 until n) {
                    val s: String = Random(sc).nextInt().toString()
                    if (s =="ball") {
                        ball++
                        if (ball == 4) {
                            println("fourball!")
                        } else {
                            println("ball!")
                        }
                    } else if (s== "strike") {
                        strike++
                        if (strike == 3) {
                            println("out!")
                        } else {
                            println("strike!")
                        }
                    }
                }
            }
}
