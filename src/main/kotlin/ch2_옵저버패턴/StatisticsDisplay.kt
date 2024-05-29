package ch2_옵저버패턴

import java.util.*

class StatisticsDisplay( var weatherData: WeatherData) : Observer, DisplayElement {
    var maxTemp : Float = 0.0F
    var minTemp : Float = 200F
    var tempSum : Float = 0.0F
     var numReading : Int = 0

    init {
        weatherData.registerObserver(this)
    }
    override fun update(temp: Float, humidity: Float, pressure: Float) {
        TODO("Not yet implemented")
    }

    override fun display() {
        TODO("Not yet implemented")
    }
}

