package ch4_팩토리패턴.simplePizzaFactory

class PizzaStore(private val factory: SimplePizzaFactory) {
    fun orderPizza(type: String?): Pizza? {
        val pizza: Pizza? = factory.createPizza(type.toString())

        pizza?.prepare()
        pizza?.bake()
        pizza?.cut()
        pizza?.box()

        return pizza
    }
}