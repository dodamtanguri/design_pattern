package ch3_데코레이터패턴

class Soy(beverage: Beverage) : CondimentDecorator() {
    init {
        this.beverage = beverage
    }

    override fun fetchDescription(): String {
        return beverage.description + ", Soy"
    }

    override fun cost(): Double {
        return 0.15 + beverage.cost()
    }
}