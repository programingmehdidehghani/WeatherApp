package com.example.weatherapp.data.remote

import retrofit2.http.Query

interface WeatherApi {

    suspend fun getWeather(
        @Query("")
    )
}