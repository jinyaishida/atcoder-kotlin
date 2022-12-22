### 問題38

Compound tasks

Implement two functions:
The first one should find the most expensive product among all the delivered products ordered by the customer. Use Order.isDelivered flag
The second one should count the number of times a product was ordered. Note that a customer may order the same product several times
Use the functions from the Kotlin standard library that were previously discussed.
You can use the Customer.getOrderedProducts() function defined in the previous task (copy its implementation).

---

解答例


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




---





