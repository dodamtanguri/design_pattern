package ch1_전략패턴

//모든 나는 행동의 클래스를 구현
interface FlyBehavior{
    fun fly()
}
//실제로 날 수 있는 오리들의 나는 행동을 구현한 클래스
//FlyWithWings 클래스는 FlyBehavior 인터페이스를 구현하고 있음.
//interface :  메소드의 시그니처 제공 But 메소드의 실제 구현 (구체적인 동작)은 제공 X
class FlyWithWings : FlyBehavior {
   override fun fly(): Unit {
        println("날고 있습니다~ ")
    }
}
//날 수 없는 오리들의 나는 행동을 구현한 클래스
class FlyNoWay : FlyBehavior {
    override fun fly() {
        println("저는 날지 못해요~")
    }
}

//-----------------------------------------------------------------------------------
// 동적으로 행동 지정하기 >> 로켓 추진으로 나는 행동을 나타내는 클래스
//-----------------------------------------------------------------------------------
class FlyRocketPowered : FlyBehavior {
    override fun fly() {
        println("로켓 추진으로 날아갑니다.")
    }
}

interface QuackBehavior{
    fun quack()
}

class Quack : QuackBehavior{
    override fun quack() {
        println("꼬ㅒㄱ")
    }
}
class MuteQuack : QuackBehavior{
    override fun quack() {
        println("조용")
    }
}
class Squeak : QuackBehavior{
    override fun quack() {
        println("삑")
    }
}

//Duck클래스의 기본 생성자는 이미 클래스 선언부에 포함되어 있음.
//기본 생성자는 Duck 클래스를 인스턴스 화 할때 FlyBehavior 와 QuackBehavior를 인자로 받아서 초기화 함.
abstract class  Duck(
    //레퍼런스 변수 2개 선언 >> 같은 패키지에 속하는 모든 서브클래스에서 이 변수를 상속 받음.
   var  flyBehavior: FlyBehavior,
   var quackBehavior: QuackBehavior
) {
    abstract fun disply()
    fun performFly() {
        flyBehavior.fly()
    }
    fun performQuack() {
        quackBehavior.quack()
    }
    fun swim() {
        println("모든 오리는 물에 뜹니다. 가짜 오리도 뜨죵")
    }

    //---------------------------------------------------------------------------------
    // 동적으로 행동 지정하기 >> Duck의 서브클래스에서 세터 메소드(Setter method)를 호출하는 방법으로 설정
    // 오리의 행동을 즉석에서 바꿀 수 있음.
    //---------------------------------------------------------------------------------
    fun changeFlyBehavior(fb: FlyBehavior) {
        flyBehavior = fb
    }
    fun changeQuackBehavior(qb: QuackBehavior) {
        quackBehavior = qb
    }


}

class MallardDuck : Duck(flyBehavior = FlyNoWay(), quackBehavior = MuteQuack()) {
    override fun disply() {
        println("저는 물오리입니다~")
    }
}

//-----------------------------------------------------------------------------------
// 동적으로 행동 지정하기
//-----------------------------------------------------------------------------------
class ModelDuck : Duck(flyBehavior = FlyNoWay(), quackBehavior = Quack()) {
    override fun disply() {
        println("저는 오리 인형 입니다.")
    }
}

class DuckCall(

   var quackBehavior: QuackBehavior){
    fun performQuack() {
        quackBehavior.quack()
    }
    fun changeQuackBehavior(qb: QuackBehavior) {
        quackBehavior   = qb
    }
}


fun main(args: Array<String>) {
    //class 의 instance를 생성하려면 일반함수처럼 생성자를 호출함. >>
    //생성된 인스턴스를 변수에 할당할 수 있음.
//       var  mallard  = MallardDuck()
//       mallard.disply() //MallardDuck은 Duck 클래스를 상속 받고 있음.
//       mallard.performQuack() //MallardDuck에서 상속 받은 performQuack()메소드 호출 >> quackBehavior 레퍼런스의 quack() 메소드가 호출
//       mallard.performFly()

     var modelDuck = ModelDuck()
        modelDuck.performFly()
        modelDuck.changeFlyBehavior(FlyRocketPowered())
        modelDuck.performFly()


   var  DuckCall = DuckCall(Quack())
   DuckCall.performQuack()
}