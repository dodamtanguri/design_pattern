package ch4_팩토리패턴.simplePizzaFactory

class VeggiePizza : Pizza() {
    init {
        name = "Veggie Pizza"
        dough = "Crust"
        sauce = "Marinara sauce"
        toppings.add("Shredded mozzarella")
        toppings.add("Grated parmesan")
        toppings.add("Diced onion")
        toppings.add("Sliced mushrooms")
        toppings.add("Sliced red pepper")
        toppings.add("Sliced black olives")
    }
}