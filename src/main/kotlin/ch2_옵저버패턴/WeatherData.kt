package ch2_옵저버패턴


interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}
//디스플레이 항목을 화면에 표시해야 할 경우 그 메소드 호출
interface DisplayElement{
    fun display()
}

interface Subject {
    fun registerObserver(o: Observer): Unit {}
    fun removeObserver(o: Observer): Unit {}
    fun notifyObserver(): Unit {}
}

class WeatherData : Subject {
   var observers : MutableList<Observer> = ArrayList()
   var temperature: Float = 0f
   var humidity: Float = 0f
   var pressure: Float = 0f
    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
observers.remove(o)
    }
    override fun notifyObserver() {
        for (observer in observers) {
            observer.update(temperature, humidity, pressure);
        }
    }
    fun measurementsChanged() {
        notifyObserver()
    }
    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }

}

//------------------------------------------------------------------------
// 디스플레이 요소 구현
// weatherData 객체로 부터 변경사항을 받으려면 Observer 클래스를 구현해야함.
// 생성자에 weatherData 주제 전달 >> 디스플레이를 옵저버로 등록.
//------------------------------------------------------------------------

// 기본 생성자는 클래스 헤더에서 클래스 인스턴스와 해당 프로퍼티 초기화 >> 실행 가능한 코드를 포함할 수 없음.
class CurrentConditionDisplay(var weatherData: WeatherData) : Observer, DisplayElement {
    var temperature : Float = 0f
    var humidity : Float = 0f
//객체를 생성하는 동안 일부 코드를 실행하려면 클래스 본문안에 init keyword 사용하여 선언.
//객체가 초기화되는 동안, 초기화 블록은 클래스 본문에 작성된 순서대로 실행 이 초기화 블록은 속성 초기화 코드와 교차(interleaved)하여 실행됩니다.
    init {
        weatherData.registerObserver(this)
    }

    override fun update(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        //데이터를 화면에 표시할때는 mvc 패턴이 좀 더 좋음
        display()
    }
    //가장 최근에 받은 온도와 습도를 출력
    override fun display() {
        println("현재 상태: 온도 $temperature F, 습도 $humidity %")
    }

}

//------------------------------------------------------------------------
// 기상 스테이션 테스트
//------------------------------------------------------------------------

class WeatherStation{
    fun main(args: Array<String>) {
        //객체 생성
        var weatherData = WeatherData()

       var currentDisplay = CurrentConditionDisplay(weatherData)
        weatherData.setMeasurements(80f,65f,30.4f)
    }
}

fun main(args: Array<String>) {
    //객체 생성
    var weatherData = WeatherData()

    var currentDisplay = CurrentConditionDisplay(weatherData)
    weatherData.setMeasurements(80f,65f,30.4f)
}