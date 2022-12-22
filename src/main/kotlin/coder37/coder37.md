### 問題37

Fold and reduce

Learn about fold and reduce and set-specific operations and implement a function that returns the set of products that all the customers ordered using reduce.
You can use the Customer.getOrderedProducts() defined in the previous task (copy its implementation).


    listOf(1, 2, 3, 4)
    .fold(1) { partProduct, element ->
    element * partProduct
    } == 24


You might also need the intersect function.

---

解答例


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

初めにallProductsという定数に一人でも注文した商品全てのセットを保存。

それをfoldの初期値に設定し、その要素とそれぞれの顧客が注文した商品で一致するものだけをorderedByAllという変数に格納していくことで、
全ての顧客によって注文された商品のセットを作成することができる。


---

知識

reduce()とfold()の違いは、
fold()は初期値を設定することができ、
それを一番最初に蓄積された値として使うが、
reduce()は一つ目の要素と二つ目の要素を最初の処理で引数として使う。

    val numbers = listOf(5, 2, 10, 4)
    
    val sum = numbers.reduce { sum, element -> sum + element }
    println(sum) //21
    val sumDoubled = numbers.fold(0) { sum, element -> sum + element * 2 }
    println(sumDoubled) //42


