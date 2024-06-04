package ch2_옵저버패턴

interface Observer {
    fun update(temp: Float, humidity: Float, pressure: Float)
    // 하위는 구현을 안해도 되게 됨. {}
  //  fun update()
}