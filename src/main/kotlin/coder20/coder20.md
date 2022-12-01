### 問題20

Rename on import

When you import a class or a function, you can specify a different name for it by adding as NewName after the import directive. It can be useful if you want to use two classes or functions with similar names from different libraries.
Uncomment the code and make it compile. Rename Random from the kotlin package to KRandom, and Random from the java package to JRandom.

---
解答例

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

---
知識

import kotlin.random.Random as KRandom　のように
as を使ってオリジナルの名前に変更することができる