package ch2_옵저버패턴

class ForecastDisplay(var weatherData: WeatherData) : Observer, DisplayElement {
   var currentPressure : Float = 29.92F
    var lastPressure : Float = 0.0F

   init {
       weatherData.registerObserver(this)
   }

    override fun update(temp: Float, humidity: Float, pressure: Float) {
       lastPressure = currentPressure
        currentPressure = pressure
        display()
    }

    override fun display() {
     print("기상예보 : ")
     if(currentPressure > lastPressure) {
         println("날씨가 좋아지고 있습니다!")
     }
        if(currentPressure == lastPressure) {
            println("지금과 비슷할 것 같습니다.")
        }
         if (currentPressure < lastPressure) {
             println("쌀쌀하며 비가 올 것 같습니다.")
         }
    }
}