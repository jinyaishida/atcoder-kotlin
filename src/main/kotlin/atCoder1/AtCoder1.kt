fun getRandomString(length: Int) : String {
    val charset = ('a'..'z')
    return (1..length)
        .map { charset.random() }
        .joinToString("")
}

fun main() {
    val length = 1000

    val randomString = getRandomString(length)

    println(randomString.lastOrNull())
}

