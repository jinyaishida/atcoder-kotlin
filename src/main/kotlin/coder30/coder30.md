### 問題30

All, Any, and other predicates

Learn about testing predicates and retrieving elements by condition.
Implement the following functions using all, any, count, find:
checkAllCustomersAreFrom should return true if all customers are from a given city
hasCustomerFrom should check if there is at least one customer from a given city
countCustomersFrom should return the number of customers from a given city
findCustomerFrom should return a customer who lives in a given city, or null if there is none


    val numbers = listOf(-1, 0, 2)
    val isZero: (Int) -> Boolean = { it == 0 }
    numbers.any(isZero) == true
    numbers.all(isZero) == false
    numbers.count(isZero) == 1
    numbers.find { it > 0 } == 2

---

解答例


    class Coder30 {
    // Return true if all customers are from a given city
    fun Shop.checkAllCustomersAreFrom(city: City): Boolean =
        customers.all{it.city == city}

    // Return true if there is at least one customer from a given city
    fun Shop.hasCustomerFrom(city: City): Boolean =
        customers.any{it.city == city}

    // Return the number of customers from a given city
    fun Shop.countCustomersFrom(city: City): Int =
        customers.count {it.city == city}

    // Return a customer who lives in a given city, or null if there is none
    fun Shop.findCustomerFrom(city: City): Customer? =
        customers.find{it.city == city}
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


predicateでは it.city でそれぞれの要素（customer）のcityと
引数に与えれたcityが等しいかを調べている

---

知識

test predicateにはall()、any()、none()の三つがある。
all()は渡されたpredicateに全ての要素が合致していればtrueを返す
any()の場合は渡されたpredicateに一つでも要素が合致していればtureを返す
none()は渡されたpredicateに要素が一つも合致していなければtrue

any()とnone()はpredicateがなくても使える。

その場合、コレクションのnullチェックが可能
any()はそのコレクションに一つでも要素があればtrue、空であればfalseを返し、
none()はその逆

