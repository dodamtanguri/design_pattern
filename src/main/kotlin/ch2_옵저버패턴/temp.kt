package ch2_옵저버패턴

class WeatherData : Subject() {
    private val observers: MutableList<Observer> = ArrayList()
    var temperature: Float = 0f
        private set
    var humidity: Float = 0f
        private set
    var pressure: Float = 0f
        private set

    override fun registerObserver(o: Observer) {
        observers.add(o)
    }

    override fun removeObserver(o: Observer) {
        observers.remove(o)
    }

    override fun notifyObserver() {
        TODO("Not yet implemented")
    }

    fun notifyObservers() {
        for (observer in observers) {
            observer.update()
        }
    }

    fun measurementsChanged() {
        notifyObservers()
    }

    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
        this.temperature = temperature
        this.humidity = humidity
        this.pressure = pressure
        measurementsChanged()
    }
}

