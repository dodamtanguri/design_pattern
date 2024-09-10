package ch8_templatemethodpattern

abstract class Beverage {

    // 템플릿 메소드
    fun prepareRecipe() {
        boilWater()
        brew()
        pourInCup()
        if (customerWantsCondiments()) {
            addCondiments()
        }
    }

    private fun boilWater() {
        println("물을 끓입니다.")
    }

    private fun pourInCup() {
        println("컵에 따릅니다.")
    }
    //  abstract 키워드를 사용해서 하위 클래스에서 반드시 재정의
    abstract fun brew()

    abstract fun addCondiments()

    // 후크 (하위 클래스에서 선택적으로 재정의 가능)
    //open keyword 클래스나 메서드를 상속 또는 재정의
    open fun customerWantsCondiments(): Boolean {
        return true
    }
}

class Coffee : Beverage() {
    override fun brew() {
        println("커피를 내립니다.")
    }

    override fun addCondiments() {
        println("설탕과 우유를 추가합니다.")
    }
}

class Tea : Beverage() {
    override fun brew() {
        println("차를 우립니다.")
    }

    override fun addCondiments() {
        println("레몬을 추가합니다.")
    }

    override fun customerWantsCondiments(): Boolean {
        return false // 레몬을 추가하지 않음
    }
}

fun main() {
    val coffee = Coffee()
    coffee.prepareRecipe()

    val tea = Tea()
    tea.prepareRecipe()
}