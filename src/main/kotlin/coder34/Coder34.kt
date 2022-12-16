package coder34

class Coder34 {
    fun main(args: Array<String>) {

        // Return all products the given customer has ordered
        fun Customer.getOrderedProducts(): List<Product> =
            orders.flatMap { it.products }

        // Return all products that were ordered by at least one customer
        fun Shop.getOrderedProducts(): Set<Product> =
            customers.flatMap { it.getOrderedProducts() }.toSet()

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