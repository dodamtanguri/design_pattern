package ch3_데코레이터패턴

abstract class Beverage {
    var description: String = "Unknown Beverage"
     open fun fetchDescription(): String {
        return description
    }

    abstract fun cost(): Double
}