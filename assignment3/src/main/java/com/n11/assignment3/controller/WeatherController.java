package com.n11.assignment3.controller;

import com.n11.assignment3.enums.Periods;
import com.n11.assignment3.response.WeatherDTO;
import com.n11.assignment3.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/weathers")
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public WeatherDTO obtainWeatherData(@RequestParam String country,
                                        @RequestParam String city,
                                        @RequestParam Periods periods) {
        return weatherService.fetchWeatherData(country, city, periods);
    }
}
