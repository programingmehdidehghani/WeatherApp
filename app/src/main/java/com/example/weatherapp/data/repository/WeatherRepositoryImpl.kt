package com.example.weatherapp.data.repository

import com.example.weatherapp.data.remote.WeatherApi
import com.example.weatherapp.domain.repository.WeatherRepository
import com.example.weatherapp.domain.util.Resource
import com.example.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository{
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        TODO("Not yet implemented")
    }


}