package ch3_데코레이터패턴

class Espresso : Beverage() {
    init {
        description = "Espresso"
    }

    override fun cost(): Double {
        return 1.99
    }
}