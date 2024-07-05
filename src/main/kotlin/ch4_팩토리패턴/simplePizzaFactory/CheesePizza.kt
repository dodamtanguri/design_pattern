package ch4_팩토리패턴.simplePizzaFactory

class CheesePizza : Pizza() {
    init {
        name = "Cheese Pizza"
        dough = "Regular Crust"
        sauce = "Marinara Pizza Sauce"
        toppings.add("Fresh Mozzarella")
        toppings.add("Parmesan")
    }
}
