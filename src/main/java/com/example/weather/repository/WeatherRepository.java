package com.example.weather.repository;



import com.example.weather.entity.Weather;
import org.springframework.stereotype.Repository;

@Repository
public class WeatherRepository {

    public Weather fetchWeatherFromApi(String city){

        // Simulating third-party API response
        return new Weather(
            city,
            31.5,
            65
        );
    }

}