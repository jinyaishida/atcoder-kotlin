package coder35

class Coder35 {
    fun main(args: Array<String>) {

        // Return a customer who has placed the maximum amount of orders
        fun Shop.getCustomerWithMaxOrders(): Customer? =
            customers.maxByOrNull { it.orders.size }

        // Return the most expensive product that has been ordered by the given customer
        fun getMostExpensiveProductBy(customer: Customer): Product? =
            customer.orders
                .flatMap { it.products }
                .maxByOrNull { it.price }

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