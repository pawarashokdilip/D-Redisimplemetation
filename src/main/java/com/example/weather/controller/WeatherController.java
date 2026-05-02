package com.example.weather.controller;


import com.example.weather.entity.Weather;

import com.example.weather.service.WeatherService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService service;

    @GetMapping("/{city}")
    public Weather getWeather(@PathVariable String city) {

        log.info("🌐 [CONTROLLER] Request received for city: {}", city);

        Weather response = service.getWeather(city);

        log.info("🌐 [CONTROLLER] Response sent for city: {}", city);

        return response;
    }
}