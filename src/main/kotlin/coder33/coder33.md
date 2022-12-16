### 問題33

Partition
Learn about partitioning and the destructuring declaration syntax that is often used together with partition.
Then implement a function for returning customers who have more undelivered orders than delivered orders using partition.
    
    val numbers = listOf(1, 3, -4, 2, -11)
    val (positive, negative) =
    numbers.partition { it > 0 }
    ​
    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)

---

解答例


        fun main(args: Array<String>) {
        // Return customers who have more undelivered orders than delivered
        fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> = customers.filter {
            val (delivered, undelivered) = it.orders.partition { it.isDelivered }
            undelivered.size > delivered.size
        }.toSet()
    }


deliveredとundeliveredごとにリストを分ける（第一引数、第二引数）



---

知識

Partition（パーティション）とは日本語で「分割」や「仕切り」を意味する
分解ともよく言われる関数

フィルタリングのための関数の一つがpartition()

引数に渡された条件式やラムダ関数に合致しない要素を別のリストとしてキープしてくれる
そのため、返り値はListのPair。
一つ目のリストには条件に合致した要素、二つ目にはそれ以外の要素が入る

---



    val numbers = listOf("one", "two", "three", "four")
    val (match, rest) = numbers.partition { it.length > 3 }
    
    println(match)  //[three, four]
    println(rest)   //[one, two]

