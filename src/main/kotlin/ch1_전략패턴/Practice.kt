package ch1_전략패턴

interface WeaponBehavior {
    fun useWeapon() {}
}

class KnifeBehavior : WeaponBehavior {
    override fun useWeapon() {
        println("나이프로 공격하기")
    }
}

class BowAndArrowBehavior : WeaponBehavior {
    override fun useWeapon() {
        println("화살로 공격하기")
    }
}
class AxeBehavior :WeaponBehavior {
    override fun useWeapon() {
        println("도끼로 공격하기")
    }
}
class SwordBehavior : WeaponBehavior {
    override fun useWeapon() {
        println("검으로 공격하기")
    }
}
 abstract class Character(
     var weaponBehavior : WeaponBehavior
 ) {
     //추상 메소드
     abstract fun fight()
 }