package ch4_팩토리패턴.simplePizzaFactory

class PepperoniPizza : Pizza() {
    init {
        name = "Pepperoni Pizza"
        dough = "Crust"
        sauce = "Marinara sauce"
        toppings.add("Sliced Pepperoni")
        toppings.add("Sliced Onion")
        toppings.add("Grated parmesan cheese")
    }
}
