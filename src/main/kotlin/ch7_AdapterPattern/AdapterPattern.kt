package ch7_AdapterPattern

// Duck 인터페이스
interface Duck {
    fun quack()
    fun fly()
}

// Turkey 인터페이스
interface Turkey {
    fun gobble()
    fun flyShort()
}

// WildTurkey 클래스, Turkey 인터페이스 구현
class WildTurkey : Turkey {
    override fun gobble() {
        println("Gobble gobble")
    }

    override fun flyShort() {
        println("I’m flying a short distance")
    }
}

// TurkeyAdapter 클래스, Duck 인터페이스 구현
class TurkeyAdapter(private val turkey: Turkey) : Duck {
    override fun quack() {
        turkey.gobble()
    }

    override fun fly() {
        // Turkey의 flyShort를 여러 번 호출하여 Duck의 fly 동작에 맞춤
        repeat(5) {
            turkey.flyShort()
        }
    }
}

fun main() {
    val turkey = WildTurkey()
    val turkeyAdapter: Duck = TurkeyAdapter(turkey)

    println("The Turkey says...")
    turkey.gobble()
    turkey.flyShort()

    println("\nThe TurkeyAdapter says...")
    turkeyAdapter.quack()
    turkeyAdapter.fly()
}