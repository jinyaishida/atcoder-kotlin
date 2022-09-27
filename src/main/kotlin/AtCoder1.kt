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

//問題文
//英小文字からなる長さ N の文字列 S が与えられます。S の末尾の文字を出力してください。
//
//制約
//N は整数
//1≤N≤1000
//S は英小文字からなる長さ N の文字列
//入力
//入力は以下の形式で標準入力から与えられる。
//
//N
//S
//出力
//S の末尾の文字を出力せよ。
//
//入力例 1
//Copy
//5
//abcde
//出力例 1
//Copy
//e
//S=abcde です。S の末尾の文字は e なので、e を出力します。
//
//入力例 2
//Copy
//1
//a
//出力例 2
//Copy
//a