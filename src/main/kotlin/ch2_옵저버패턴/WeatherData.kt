package ch2_옵저버패턴

//
//class WeatherData : Subject() {
//   var observers : MutableList<Observer> = ArrayList()
//   var temperature: Float = 0f
//   var humidity: Float = 0f
//   var pressure: Float = 0f
//    override fun registerObserver(o: Observer) {
//        observers.add(o)
//    }
//
//    override fun removeObserver(o: Observer) {
//    observers.remove(o)
//    }
//    override fun notifyObserver() {
//        for (observer in observers) {
//          //------------------------------------------------
//          // 푸시 방식 : 주제가 옵저버로 데이터를 보냄.
//          //------------------------------------------------
//          //  observer.update(temperature, humidity, pressure);
//            //------------------------------------------------
//            // 풀 방식 : 옵저버가 주제로부터 데이터를 당겨옴.
//            //------------------------------------------------
//            observer.update()
//        }
//    }
//    fun measurementsChanged() {
//        notifyObserver()
//    }
//    fun setMeasurements(temperature: Float, humidity: Float, pressure: Float) {
//        this.temperature = temperature
//        this.humidity = humidity
//        this.pressure = pressure
//        measurementsChanged()
//    }
//
//
//}
//
