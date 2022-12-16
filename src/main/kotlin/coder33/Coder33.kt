package coder33

class Coder33 {
    fun main(args: Array<String>) {
        // Return customers who have more undelivered orders than delivered
        fun Shop.getCustomersWithMoreUndeliveredOrders(): Set<Customer> = customers.filter {
            val (delivered, undelivered) = it.orders.partition { it.isDelivered }
            undelivered.size > delivered.size
        }.toSet()
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