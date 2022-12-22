### 問題36

Sum

Implement a function that calculates the total amount of money the customer has spent: the sum of the prices for all the products ordered by a given customer. Note that each product should be counted as many times as it was ordered.
Use sum on a collection of numbers or sumOf to convert the elements to numbers first and then sum them up.

    listOf(1, 5, 3).sum() == 9
    listOf("a", "b", "cc").sumOf { it.length } == 4

---

解答例


        class Coder36 {
    fun main(args: Array<String>) {

        // Return the sum of prices for all the products ordered by a given customer
        fun moneySpentBy(customer: Customer): Double =
            customer.orders.flatMap { it.products }.sumOf { it.price }

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

Double型を返したいのでsumByDouble
引数に渡されたcustomerからordersを取り出し、
それにflatMapを使ってネストの階層を平坦にしていることがポイント
その後、flatMapで平坦にしたproductのpriceの合計を求める処理をsumByDoubleで実行

例

    val list = listOf(listOf("a", "b"), listOf("c", "d"), listOf("e", "f"))
    
    list.flatMap { it } //[a, b, c, d, e, f]



---

知識

リストの要素の合計はsum()関数で取得することができる。

    listOf(1, 5, 3).sum() == 9

リストに含まれる要素の文字列の文字数の合計を求めル時は下記。

    listOf("a", "b", "cc").sumBy { it.length } == 4



