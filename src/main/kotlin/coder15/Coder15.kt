package coder15

class Coder15 {
    fun main(args: Array<String>) {
        fun containsEven(collection: Collection<Int>): Boolean =
            collection.any { i -> i % 2 == 0 }
    }

}