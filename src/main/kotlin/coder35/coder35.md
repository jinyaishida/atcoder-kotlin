### 問題33

Max min
Learn about collection aggregate operations.
Implement two functions:
The first should return the customer who has placed the most amount of orders in this shop
The second should return the most expensive product that the given customer has ordered
The functions maxOrNull, minOrNull, maxByOrNull, and minByOrNull might be helpful.

    listOf(1, 42, 4).maxOrNull() == 42
    listOf("a", "ab").minByOrNull(String::length) == "a"


You can use callable references instead of lambdas. It can be especially helpful in call chains, where it occurs in different lambdas and has different types. Implement the getMostExpensiveProductBy function using callable references.

---

解答例


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

最大数を求めるためmax関数のorders.sizeで求めることが可能。
flatmapを使うことで注文した中で、を作り、max関数で最高額商品を返している


---

知識

    minOrNull()とmaxOrNull()：それぞれ要素の最小値と最大値を返す。空のコレクションに対してはnullを返す。
    average()：数値のコレクションの要素の平均値を返す。
    sum()：数値のコレクションの要素の合計の値を返す。
    count()：コレクションの要素の数を返す。



