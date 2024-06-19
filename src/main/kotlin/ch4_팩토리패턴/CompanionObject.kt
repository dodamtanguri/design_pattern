package ch4_팩토리패턴

/*
* CompanionObject를 사용하는 이유
* 싱글톤 패턴을 자연스럽게 지원.
* 클래스의 정적메소드 처럼 동작.
* 팩토리 메소드를 간편하게 구현 가능
* 클래스와 팩토리메소드 간의 관계가 명확해지고 코드의 응집도가 올라감.
* */

interface Factory<T> {
    fun create(): T
}

class CompanionObject {
    companion object : Factory<CompanionObject> {
        override fun create(): CompanionObject = CompanionObject()
    }

}
fun main() {
    val instance: CompanionObject = CompanionObject.create()
    println(instance)
}