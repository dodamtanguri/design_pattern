package kotlin_introduction
//기본 클래스 정의
open class A {
    open fun foo(i: Int = 10) {
        println("A: i = $i")
    }
}//기본 클래스를 상속받아 메소드 오버라이딩
class B : A() {
    override fun foo(i: Int) {
        println("B: i = $i")
    }
}
// B 클래스의 foo 메소드는 기본 파라미터 값을 포함하지 않지만, A클래스의 기본 파라미터값이 그대로 사용됨.
// 오버라이딩된 메소드가 기본 메소드의 기본 파라미터 값을 따라감.
fun main(args: Array<String>) {
    val a = A()
    var b = B()

    //A 클래스의 foo 메소드 호출
    a.foo() // 예상 : 10(기본값)
    a.foo(20) // 예상 : 20

    //B 클래스의 foo 메소드 호출
    b.foo() // 예상 10
    b.foo(20) // 예상 20
}