package ch5_싱글톤패턴
// object keyword를 사용해서 싱글톤 클래스 만들 수 있음.
object Singleton {
    var x = "some string"
    init {
        println("singleton init")
    }
    fun doSomething() {
        println("singleton doSomething")
    }
}

class A {
    companion object {
        var x = "some string"
    }
}

fun main() {
    Singleton.doSomething()
    Singleton.x = "some string"
    A.x;

}