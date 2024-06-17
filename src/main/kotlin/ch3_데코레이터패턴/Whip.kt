package ch3_데코레이터패턴

class Whip(beverage: Beverage) : CondimentDecorator() {
    init {
        this.beverage = beverage
    }

    override fun fetchDescription(): String {
        return beverage.description + ", Whip"
    }

    override fun cost(): Double {
        return 0.10 + beverage.cost()
    }
}
