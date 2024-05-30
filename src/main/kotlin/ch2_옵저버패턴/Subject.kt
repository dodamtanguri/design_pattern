package ch2_옵저버패턴

interface Subject {
    fun registerObserver(o: Observer): Unit {}
    fun removeObserver(o: Observer): Unit {}
    fun notifyObserver(): Unit {}
}
