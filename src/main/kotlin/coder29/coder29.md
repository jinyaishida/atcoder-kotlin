### 問題29

Filter; map

Learn about mapping and filtering a collection.
Implement the following extension functions using the map and filter functions:
Find all the different cities the customers are from
Find the customers living in a given city

    val numbers = listOf(1, -1, 2)
    numbers.filter { it > 0 } == listOf(1, 2)
    numbers.map { it * it } == listOf(1, 1, 4)


    val strings = listOf("bbb", "a", "cc")
    strings.sorted() ==
    listOf("a", "bbb", "cc")
    
    strings.sortedBy { it.length } ==
    listOf("a", "cc", "bbb")
    
    strings.sortedDescending() ==
    listOf("cc", "bbb", "a")
    
    strings.sortedByDescending { it.length } ==
    listOf("bbb", "cc", "a")

---

解答例


    class Coder29 {
    fun main(args: Array<String>) {
        // Find all the different cities the customers are from
        fun Shop.getCustomerCities(): Set<City> =
            customers.map { it.city }.toSet()

        // Find the customers living in a given city
        fun Shop.getCustomersFrom(city: City): List<Customer> =
            customers.filter { it.city == city }
    }
    data class Shop(val name: String, val customers: List<Customer>)

    data class Customer(val name: String, val city: City, val orders: List<Order>) {
        override fun toString() = "$name from ${city.name}"
    }

    data class Order(val products: List<Product>, val isDelivered: Boolean)

    data class Product(val name: String, val price: Double) {
        override fun toString() = "'$name' for $price"
    }

    data class City(val name: String) {
        override fun toString() = name
    }
    }

map

mapでShopのcustomers（List型）をcityのリストに変換。
ただし、返り値はSet型にしなければならないため、 最後にtoSet()をつけてListからSetに変換する。

filter

getCustomersFrom関数に渡されたcityと
customersに含まれる要素のcityが合致するかを調べるpredicateを指定。

---

知識

map()は与えられたラムダ関数を後続の要素に適用し、そのラムダの結果のリストを返す。
順番は元々の要素の順番と同じ。
引数として要素のインデックス番号を使う変換を適用する場合は、mapIndexed()。

filter()はコレクションの中から特定の条件を満たす（または満たさない）要素だけを抽出する
it.length のitはnumbersに含まれるそれぞれの要素を意味する。

例

    val numbers = listOf("one", "two", "three", "four")  
    val longerThan3 = numbers.filter { it.length > 3 } //要素が3より大きい
    println(longerThan3) //[three, four]


