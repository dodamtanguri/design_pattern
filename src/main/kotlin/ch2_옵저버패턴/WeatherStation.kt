package ch2_옵저버패턴

  class WeatherStation{
      class WeatherStation {
          companion object {
              @JvmStatic
              fun main(args: Array<String>) {
                  // 객체 생성
                  val weatherData = WeatherData()
                  val currentDisplay = CurrentConditionDisplay(weatherData)
                  val statisticsDisplay = StatisticsDisplay(weatherData)
                  val forecastDisplay = ForecastDisplay(weatherData)
                  weatherData.setMeasurements(80f, 65f, 30.4f)
                  weatherData.setMeasurements(82f, 70f, 29.2f);
                  weatherData.setMeasurements(78f, 90f, 29.2f);

                  weatherData.removeObserver(forecastDisplay);
                  weatherData.setMeasurements(62f, 90f, 28.1f);
              }
          }
      }
  }
