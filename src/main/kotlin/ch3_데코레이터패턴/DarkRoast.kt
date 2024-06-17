package ch3_데코레이터패턴

class DarkRoast : Beverage() {
    init {
        description = "Dark Roast Coffee"
    }

    override fun cost(): Double {
        return 0.99
    }
}