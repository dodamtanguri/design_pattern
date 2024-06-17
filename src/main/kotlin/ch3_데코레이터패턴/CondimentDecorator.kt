package ch3_데코레이터패턴

abstract class CondimentDecorator : Beverage() {
      lateinit var beverage: Beverage
    abstract override fun fetchDescription(): String
}