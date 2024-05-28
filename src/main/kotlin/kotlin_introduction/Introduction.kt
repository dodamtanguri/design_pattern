package kotlin_introduction

fun printMessage(message:String): Unit {
    println(message)
}
//Optional parameter with default value >> return type 이 생략 되어 있어서 실제로는 Unit을 반환함.
//Default Value >> 해당 인수를 skip 할때 사용하는 기본값 존재 (오버로드 횟수 감소)
fun printMessageWithPrefix(message: String, prefix: String = "INFO"): Unit {
    println("[$prefix] $message")
}
fun sum(x: Int, y: Int): Int {
    return x + y
}
//int를 return 하는 single-expression function
fun multiple(x: Int, y: Int): Int = x * y

fun main(args: Array<String>) {
    println("hello world")
    printMessage("hello world222")
    printMessageWithPrefix("hello world", "Log")
   printMessageWithPrefix("Hello")
    //named arguments
    printMessageWithPrefix(prefix = "Log", message = "Hello")
    println(sum(1, 2))
    println(multiple(1, 2))
}