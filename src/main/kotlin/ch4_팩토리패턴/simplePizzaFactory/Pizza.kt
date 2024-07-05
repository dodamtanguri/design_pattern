package ch4_팩토리패턴.simplePizzaFactory

abstract class Pizza {
    var name: String? = null
    var dough: String? = null
    var sauce: String? = null
    val toppings: MutableList<String> = mutableListOf()

    fun prepare() {
        println("Preparing $name")
    }

    fun bake() {
        println("Baking $name")
    }

    fun cut() {
        println("Cutting $name")
    }

    fun box() {
        println("Boxing $name")
    }

    override fun toString(): String {
        // code to display pizza name and ingredients
        val display = StringBuffer()
        display.append("---- $name ----\n")
        display.append(dough + "\n")
        display.append(sauce + "\n")
        for (topping in toppings) {
            display.append(topping + "\n")
        }
        return display.toString()
    }
}

