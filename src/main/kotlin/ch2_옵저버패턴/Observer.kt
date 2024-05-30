package ch2_옵저버패턴

interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
}