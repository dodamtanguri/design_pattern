package ch3_데코레이터패턴

fun main() {
    val beverage: Beverage = Espresso()
    println("${beverage.description} $${beverage.cost()}")

    var beverage2: Beverage = DarkRoast()
    beverage2 = Mocha(beverage2)
    beverage2 = Mocha(beverage2)
    beverage2 = Whip(beverage2)
    println("${beverage2.fetchDescription()} $${beverage2.cost()}")

    var beverage3: Beverage = HouseBlend()
    beverage3 = Soy(beverage3)
    beverage3 = Mocha(beverage3)
    beverage3 = Whip(beverage3)
    println("${beverage3.fetchDescription()} $${beverage3.cost()}")
}