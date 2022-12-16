### 問題31

Associate

Learn about association. Implement the following functions using associateBy, associateWith, and associate:
Build a map from the customer name to the customer
Build a map from the customer to their city
Build a map from the customer name to their city

    val list = listOf("abc", "cdef")
    
    list.associateBy { it.first() } ==
    mapOf('a' to "abc", 'c' to "cdef")
    
    list.associateWith { it.length } ==
    mapOf("abc" to 3, "cdef" to 4)
    
    list.associate { it.first() to it.length } ==
    mapOf('a' to 3, 'c' to 4)
    val list = listOf("abc", "cdef")
    ​
    list.associateBy { it.first() } ==
    mapOf('a' to "abc", 'c' to "cdef")
    ​
    list.associateWith { it.length } ==
    mapOf("abc" to 3, "cdef" to 4)
    ​
    list.associate { it.first() to it.length } ==
    mapOf('a' to 3, 'c' to 4)

---

解答例


        fun main(args: Array<String>) {

        // Build a map from the customer name to the customer
        //customerの名前がキー、customerが値のマップを返す

        fun Shop.nameToCustomerMap(): Map<String, Customer> =
            customers.associateBy { it.name }

        // Build a map from the customer to their city
        //customerがキー、customerのcityが値のマップを返す

        fun Shop.customerToCityMap(): Map<Customer, City> =
            customers.associateWith { it.city }

        // Build a map from the customer name to their city
        //customerの名前がキー、customerのcityが値のマップを返す

        fun Shop.customerNameToCityMap(): Map<String, City> =
            customers.associate { it.name to it.city }
    }


nameToCutomerMap()はキーが元のリストとなるcustomersから生成されたnameなので、associateBy()

逆にcustomerToCityMap()ではキーがcustomersの要素であるcustomerなので、associateWith()

customerNameToCityMap()ではキーも値もcustomersから生成されたものを設定したいので、associate




---

知識

Association変換でMapを作成。
associateWith()、associateBy()、associate()の3つある。
---
associateWith()
もとのコレクションの要素がキーとなり、
引数に与えられた変換関数によって生成された値がMapの値になる


    val numbers = listOf("one", "two", "three", "four")
    println(numbers.associateWith { it.length })
    //{one=3, two=3, three=5, four=4}
---

associateBy()
もとのコレクションの要素を値とするMapを作るためにはこれ
要素の値に基づいたキーを返す関数を引数にとり、Mapを作成

    val numbers = listOf("one", "two", "three", "four")
    println(numbers.associateBy { it.first().uppercaseChar() })
    //{O=one, T=three, F=four}

出力結果ではもとのリストの要素が値になっていることに注目

---

associate()
キーと値の両方がなんらかの形でもとのコレクションの要素から生成される場合はassociate()
これは対応するMapのエントリのキーと値のPairを返すラムダ関数を引数にとる

    val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
    println(names.associate { name -> parseFullName(name).let { it.lastName to it.firstName } })  
    //{Adams=Alice, Brown=Brian, Campbell=Clara}


---
簡略版

    val list = listOf("abc", "cdef")
    print(list.associate { it.first() to it.length } )
    //{a=3, c=4}