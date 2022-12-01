package coder20

import kotlin.random.Random as KRandom
import java.util.Random as JRandom

class Coder20 {
    fun main(args: Array<String>){

        fun useDifferentRandomClasses(): String {
            return "Kotlin random: " +
                    KRandom.nextInt(2) +
                    " Java random:" +
                    JRandom().nextInt(2) +
                    "."
        }
    }
}