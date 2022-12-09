### 問題28

Sort

Learn about collection ordering and the the difference between operations in-place on mutable collections and operations returning new collections.
Implement a function for returning the list of customers, sorted in descending order by the number of orders they have made. Use sortedDescending or sortedByDescending.
val strings = listOf("bbb", "a", "cc")
strings.sorted() ==
listOf("a", "bbb", "cc")
​
strings.sortedBy { it.length } ==
listOf("a", "cc", "bbb")
​
strings.sortedDescending() ==
listOf("cc", "bbb", "a")
​
strings.sortedByDescending { it.length } ==
listOf("bbb", "cc", "a")

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


    class Coder28 {
    fun main(args: Array<String>) {
        fun Shop.getCustomersSortedByOrders(): List<Customer> =
            customers.sortedByDescending { it.orders.size }
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


Shopクラスのcustomers（List型）に対してsortedByDescendingを使い、
そのcustomersの中のそれぞれのcustomerがもつorders（List型）の
サイズ（ordersに含まれるorderの数＝注文数）をチェックしている
セレクター関数　it.orders.size　==　顧客の注文数の数

---

知識

自分で定義した型にナチュラルオーダーを定義するには、
その型にComparableを継承させる。そのためにはcompareTo()関数が必要。
カスタムオーダーをある型に定義するには、Comparatorをその型に作成。


