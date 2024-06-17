package ch3_데코레이터패턴

class Mocha(beverage: Beverage) : CondimentDecorator() {
    init {
        this.beverage = beverage
    }

    override fun fetchDescription(): String {
        return beverage.description + ", Mocha"
    }

    override fun cost(): Double {
        return 0.20 + beverage.cost()
    }
}