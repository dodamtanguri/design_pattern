package ch2_옵저버패턴

abstract class Subject {
   abstract fun registerObserver(o: Observer)
    abstract fun removeObserver(o: Observer)
    abstract fun notifyObserver()
}
