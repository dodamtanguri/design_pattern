package ch2_옵저버패턴


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

