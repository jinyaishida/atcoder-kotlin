### 問題11
---
Triple-quoted strings
Learn about the different string literals and string templates in Kotlin.
You can use the handy library functions trimIndent and trimMargin to format multiline triple-quoted strings in accordance with the surrounding code.
Replace the trimIndent call with the trimMargin call taking # as the prefix value so that the resulting string doesn't contain the prefix character.
___

解答例

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

---

知識

---
    trimMargin は指定された文字(列)に至るまでの空白とその文字(列)を消してくれるもので、 
    trimIndent は左側にあるスペースを、一番インデントの少ない行に合わせて消してくれるもの。
    trimMargin()のデフォルトでのマージン接頭辞は｜に設定されているが、
    trimgMargin(“>”)のように引数に任意の文字を入れることで、
    それをマージン接頭辞として設定することが可能になり、消すものを指定できる。
