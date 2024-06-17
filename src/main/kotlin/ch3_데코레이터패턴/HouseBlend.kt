package ch3_데코레이터패턴

class HouseBlend : Beverage() {
    init {
        description = "House Blend Coffee"
    }

    override fun cost(): Double {
        return .89
    }
}

