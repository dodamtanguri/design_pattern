package kotlin_introduction

fun main() {
    //infix 키워드 >> 점과 괄호 없이 호출 할 수 있음.
    //1. 멤버함수 또는 확장 함수여야함.
    //2. 단일파라미터
    //3. 파라미터는 가변 인자를 받아들이지 X 기본값이어야함.
    infix fun Int.times(str: String) = str.repeat(this)
    println(2 times "Bye ")

    var pair = "Ferrari " to "Katrina"
    println(pair)
    //항상 수신자와 파라미터를 명시해야함.
    //this 를 명시적으로 사용해야함 >> 모호한 구문 분석을 방지하기 위함.
    infix fun String.onto(other: String) = Pair(this, other)
    var myPair = "McLaren" onto "Maria"
    println(myPair)

    val sophia = Person("Sophia")
    val claudia = Person("Claudia")
    sophia likes claudia
}

class Person(val name: String) {
    val likedPeople = mutableListOf<Person>()
    infix fun likes(other: Person) {
        likedPeople.add(other)
    }

}
