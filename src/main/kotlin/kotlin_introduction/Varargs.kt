package kotlin_introduction
//Variable number of arguments(varargs)
//함수의 파라미터(주로 마지막파라미터)에 vararg 를 사용해서 가변인자를 받을 수 있음.
//
fun main() {
    printAll("abc", "def")
    printAllWithPrefix(
        "Hello", "Hallo", "Salut", "Hola", "你好",
        prefix = "Greeting: "
    )
    log("Hello", "Hallo", "Salut", "Hola", "你好")
}

fun printAll(vararg messages : String): Unit {
    for(m in messages){
        println(m)
    }
}
//가변 인자 함수를 호출할때 개별인자를 전달 할 수 있음.
fun printAllWithPrefix(vararg messages: String , prefix: String): Unit {
    for(m in messages){
        println( prefix + m)
    }
}
//이미 배열이 있고 그 내용을 함수에 전달하려면, 스프레드 연산자를 배열앞에 붙여서 사용하면 됨.
//런타임 시점이 vararg 는 이미 배열(array) 임.
fun log(vararg entries: String) {
    printAll(*entries);
}
