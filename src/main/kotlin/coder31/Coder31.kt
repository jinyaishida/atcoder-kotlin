package coder31

import coder30.City

class Coder31 {
    fun main(args: Array<String>) {
        // Build a map from the customer name to the customer
        fun Shop.nameToCustomerMap(): Map<String, Customer> =
            customers.associateBy { it.name }

        // Build a map from the customer to their city
        fun Shop.customerToCityMap(): Map<Customer, City> =
            customers.associateWith { it.city }

        // Build a map from the customer name to their city
        fun Shop.customerNameToCityMap(): Map<String, City> =
            customers.associate { it.name to it.city }
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