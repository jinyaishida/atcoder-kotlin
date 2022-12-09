package coder29

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