### 問題32

Group By

Learn about grouping. Use groupBy to implement the function to build a map that stores the customers living in a given city.

    val result =
    listOf("a", "b", "ba", "ccc", "ad")
    .groupBy { it.length }
    ​
    result == mapOf(
    1 to listOf("a", "b"),
    2 to listOf("ba", "ad"),
    3 to listOf("ccc"))

---

解答例


        fun main(args: Array<String>) {
        // Build a map that stores the customers living in a given city
        fun Shop.groupCustomersByCity(): Map<City, List<Customer>> =
            customers.groupBy { it.city }
    }


引数にit.cityを指定することで
customers中のそれぞれのcustomerのcityプロパティで分類



---

知識

groupBy()はコレクションの要素をグルーピングするための拡張関数
ラムダ関数を引数にとり、Mapを返す。

使用例
文字列を最初の文字ごとにグルーピング

---
2つ目の引数に変換関数であるラムダ関数を設定して呼び出すことも可能


    val numbers = listOf("one", "two", "three", "four", "five")

    println(numbers.groupBy { it.first().uppercase() })
    //{O=[one], T=[two, three], F=[four, five]}
    println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.uppercase() }))
    //{o=[ONE], t=[TWO, THREE], f=[FOUR, FIVE]}

