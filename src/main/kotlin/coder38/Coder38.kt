package coder38

class Coder38 {
    fun main(args: Array<String>) {

        fun findMostExpensiveProductBy(customer: Customer): Product? {
            return customer
                .orders
                .filter(Order::isDelivered)
                .flatMap(Order::products)
                .maxByOrNull(Product::price)
        }
    }

        fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
            return customers
                .flatMap(Customer::getOrderedProducts)
                .count { it == product }
        }
    }
        fun Customer.getOrderedProducts(): List<Product> = orders.flatMap(Order::products)

        fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
            return customers
                .flatMap(Customer::orders)
                .flatMap(Order::products)
                .count { it == product }
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
