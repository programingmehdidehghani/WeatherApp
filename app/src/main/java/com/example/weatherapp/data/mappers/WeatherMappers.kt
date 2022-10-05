package com.example.weatherapp.data.mappers

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.weatherapp.data.remote.WeatherDataDto
import com.example.weatherapp.domain.weather.WeatherData
import com.example.weatherapp.domain.weather.WeatherType
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


data class IndexedWeatherData(
    val index : Int,
    val data : WeatherData
)

@RequiresApi(Build.VERSION_CODES.O)
fun WeatherDataDto.toWeatherDataMap(): Map<Int , List<WeatherData>>{
      return time.mapIndexed{ index, time ->
          val temperature = temperatures[index]
          val weatherCode = weatherCodes[index]
          val windSpeed = windSpeeds[index]
          val pressure = pressures[index]
          val humidity = humidities[index]
          WeatherData(
              time = LocalDateTime.parse(time , DateTimeFormatter.ISO_DATE_TIME),
              temperatureCelsius = temperature,
              pressure = pressure,
              windSpeed = windSpeed,
              humidity = humidity,
              weatherType = WeatherType.fromWMO(weatherCode)
          )
      }.groupBy {
          it.time.dayOfMonth
      }
}