### 問題34

FlatMap

Learn about flattening and implement two functions using flatMap:
The first should return all products the given customer has ordered
The second should return all products that at least one customer ordered

    val result = listOf("abc", "12")
    .flatMap { it.toList() }
    ​
    result == listOf('a', 'b', 'c', '1', '2')

---

解答例


            fun main(args: Array<String>) {

        // Return all products the given customer has ordered
        fun Customer.getOrderedProducts(): List<Product> =
            orders.flatMap { it.products }

        // Return all products that were ordered by at least one customer
        fun Shop.getOrderedProducts(): Set<Product> =
            customers.flatMap { it.getOrderedProducts() }.toSet()

    }


考え方

    １、最終的にフラットにして利用したいのは何かを考える。
    
    　　この場合は、顧客のもつ商品情報（Products）で、
    
    　　flatMapの引数にはproducts

---


    ２、getOrderedProducts()が顧客が注文した商品を全て返しているので、
    
    　　これを引数にして全ての顧客上で呼び出す。　→　全ての顧客が注文した商品を全て取り出せる。
    
    　　つまり誰かが一度でも注文した商品は全てここに含まれていることになります。
    
    　　戻り値の型がSetなので、末尾はtoSet()


---

知識

Kotlinの flatMap は、map と flatten が一緒になったもの
flatMapは引数で指定した式や関数で要素を別のコレクションにできる

ポイント

    map は、1つの入力が1つの出力になる場合に使用する
    flatMap は、1つの入力が複数の出力に増える場合に使用する

例えば、

    APIに検索条件を渡すと結果が複数返ってくるケース
    DBを検索すると結果が複数返ってくるケース

---

基本的な map / flatMap の動作

    fun example() {
    val list = listOf(1, 2, 3)

    // map
    val convertedByMap = list
        .map { listOf(it, it) }
    println(convertedByMap)
    // [[1, 1], [2, 2], [3, 3]]

    // map + flatten
    val convertedByMapFlatten = list
        .map { listOf(it, it) }
        .flatten()
    println(convertedByMapFlatten)
    // [1, 1, 2, 2, 3, 3]

    // flatMap
    val convertedByFlatMap = list
        .flatMap { listOf(it, it) }
    println(convertedByFlatMap)
    // [1, 1, 2, 2, 3, 3]
    }

