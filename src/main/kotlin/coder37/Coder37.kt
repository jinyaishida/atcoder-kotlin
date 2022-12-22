package coder37

class Coder37 {
    fun main(args: Array<String>) {

        //全ての顧客によって注文された商品のセットを返す
        fun Shop.getProductsOrderedByAll(): Set<Product> {
            val allProducts = customers.flatMap { it.getOrderedProducts() }.toSet()
            return customers.fold(
                allProducts,
                { orderedByAll, customer ->
                    orderedByAll.intersect(customer.getOrderedProducts())
                },
            )
        }
    }
        fun Customer.getOrderedProducts(): List<Product> =
            orders.flatMap(Order::products)

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