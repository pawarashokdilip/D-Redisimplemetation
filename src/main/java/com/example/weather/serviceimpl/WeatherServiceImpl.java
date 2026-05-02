package com.example.weather.serviceimpl;





import com.example.weather.entity.Weather;
import com.example.weather.repository.WeatherRepository;
import com.example.weather.service.WeatherService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private WeatherRepository repository;

    @Override
    public Weather getWeather(String city) {

        String key = "weather:" + city;

        log.info("🔹 [SERVICE] Step 1: Checking cache for key: {}", key);

        // Step 1: Check cache
        Weather cachedWeather = (Weather) redisTemplate.opsForValue().get(key);

        if (cachedWeather != null) {
            log.info("✅ [SERVICE] CACHE HIT for city: {}", city);
            return cachedWeather;
        }

        log.info("❌ [SERVICE] CACHE MISS for city: {}", city);

        // Step 2: API call
        log.info("📡 [SERVICE] Calling external API / DB for city: {}", city);
        Weather weather = repository.fetchWeatherFromApi(city);

        // Step 3: Store in Redis
        log.info("💾 [SERVICE] Saving data to Redis with TTL 10 minutes for city: {}", city);

        redisTemplate.opsForValue().set(
                key,
                weather,
                10,
                TimeUnit.MINUTES
        );

        log.info("🎯 [SERVICE] Returning fresh data for city: {}", city);

        return weather;
    }
}