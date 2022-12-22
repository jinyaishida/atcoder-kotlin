package coder36

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