package ch4_팩토리패턴.simplePizzaFactory

class ClamPizza : Pizza() {
    init {
        name = "Clam Pizza"
        dough = "Thin crust"
        sauce = "White garlic sauce"
        toppings.add("Clams")
        toppings.add("Grated parmesan cheese")
    }
}
