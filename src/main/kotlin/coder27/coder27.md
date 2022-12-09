### 問題27

Collections Introduction

This section was inspired by GS Collections Kata.
Kotlin can be easily mixed with Java code. Default collections in Kotlin are all Java collections under the hood. Learn about read-only and mutable views on Java collections.
The Kotlin standard library contains lots of extension functions that make working with collections more convenient. For example, operations that transform a collection into another one, starting with 'to': toSet or toList.
Implement the extension function Shop.getSetOfCustomers(). The class Shop and all related classes can be found in Shop.kt.

---

解答例


    class Coder27 {
    fun main(args: Array<String>) {
        fun Shop.getSetOfCustomers(): Set<Customer> =
            customers.toSet()
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


Shopクラスに含まれているCustomersはList<Customer>型なので、Set<Customer>型に変換する

---

知識

List<T>は指定された順番で要素を格納して、インデックス番号をつける。重複OK.
リスト同士は同じサイズ（要素数が同じ）で同じ位置に同じ要素がある場合、等しいものとみなされる


例

    val bob = Person("Bob", 31)
    val people = listOf(Person("Adam", 20), bob, bob)
    val people2 = listOf(Person("Adam", 20), Person("Bob", 31), bob)
    println(people == people2) //true
    bob.age = 32
    println(people == people2) //false

---

Set<T>は一意性を持つ（かぶりがない）要素を格納。順番なし。nullも一つのみ。
Set同士はサイズが同じ（要素数が同じ）で、Setのそれぞれの要素と等しい要素がもう一方のSetに含まれていれば等しいものとみなされる。

順番逆でもOKな例:

    val numbers = setOf(1, 2, 3, 4)
    println("Number of elements: ${numbers.size}")
    if (numbers.contains(1)) println("1 is in the set")
    
    val numbersBackwards = setOf(4, 3, 2, 1)
    println("The sets are equal: ${numbers == numbersBackwards}")
    
    //出力結果
    //Number of elements: 4
    //1 is in the set
    //The sets are equal: true

---

Mapはキーと値（またはエンティティ）のペアを格納。順番関係なし。
Map同士は等しいペアを格納をしていれば、ペアの順番に関係なく等しいものをみなされる。

---

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)    
    val anotherMap = mapOf("key2" to 2, "key1" to 1, "key4" to 1, "key3" to 3)
    
    println("The maps are equal: ${numbersMap == anotherMap}") //true

---
