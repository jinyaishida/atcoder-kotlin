Learn about classes, properties and data classes and then rewrite the following Java code to Kotlin:
    
    public class Person {
    private final String name;
    private final int age;
    ​
    public Person(String name, int age) {
    this.name = name;
    this.age = age;
    }
    ​
    public String getName() {
    return name;
    }
    ​
    public int getAge() {
    return age;
    }
    }
Afterward, add the data modifier to the resulting class. The compiler will generate a few useful methods for this class: equals/hashCode, toString, and some others.

---
解答例

    data class Person(val name: String, val age: Int)
    
    fun getPeople(): List<Person> {
    return listOf(Person("Alice", 29), Person("Bob", 31))
    }
    
    fun comparePeople(): Boolean {
    val p1 = Person("Alice", 29)
    val p2 = Person("Alice", 29)
    return p1 == p2  

---
知識

データクラスを使うと、equals,hashCode(),toString(),componentN(),copy()等のメソッドが自動生成されるようになる

dataをつけることでパラメーターの中身が自動でクラスメンバになり、自動生成されたメソッドが使えるようになる。
