package ch2_옵저버패턴

//평균, 최저, 최고값 표시
/**
 *
 */
class StatisticsDisplay( var weatherData: WeatherData) : Observer, DisplayElement {
    var maxTemp : Float = 0.0F
    var minTemp : Float = 200F
    var tempSum : Float = 0.0F
     var numReading : Int = 0

    init {
        weatherData.registerObserver(this)
    }
//    override fun update(temp: Float, humidity: Float, pressure: Float) {
//
//       var currentTemp : Float = weatherData.temperature
//
//       this.tempSum += currentTemp;
//       this.numReading++;
//
//        if (currentTemp > maxTemp) {maxTemp = currentTemp}
//        if (currentTemp < minTemp) {minTemp = currentTemp}
//        display()
//    }
    override fun update() {
        var currentTemp : Float = weatherData.temperature

      this.tempSum += currentTemp;
    this.numReading++;
               if (currentTemp > maxTemp) {maxTemp = currentTemp}
       if (currentTemp < minTemp) {minTemp = currentTemp}
       display()
    }

    override fun display() {
     println("평균/최고/최저 온도 = ${tempSum/ numReading}/$maxTemp/$minTemp")
    }
}

