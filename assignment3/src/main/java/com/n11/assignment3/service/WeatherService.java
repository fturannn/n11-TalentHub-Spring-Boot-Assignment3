package com.n11.assignment3.service;

import com.n11.assignment3.client.WeatherClient;
import com.n11.assignment3.enums.Periods;
import com.n11.assignment3.response.WeatherDTO;
import com.n11.assignment3.response.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class WeatherService {
    private final WeatherClient weatherClient;
    private final CityService cityService;


    public WeatherDTO fetchWeatherData(String selectedCountry, String selectedCity, Periods selectedPeriod) {
        double[] coordinates = cityService.retrieveCoordinatesByCityAndCountry(selectedCountry, selectedCity);
        String timeIdentifier = "time";
        String temperatureIdentifier = "temperature_2m";
        WeatherResponse weatherInfo = weatherClient.obtainWeatherData(coordinates[0], coordinates[1], temperatureIdentifier, selectedPeriod.obtainPeriod());

        String[] timestamps = weatherInfo.hourly().get(timeIdentifier);
        String[] temperatures = weatherInfo.hourly().get(temperatureIdentifier);

        Map<LocalDateTime, String> weatherDataMap = new HashMap<>();
        for (int i = 0; i < timestamps.length; i++) {
            weatherDataMap.put(
                    LocalDateTime.parse(timestamps[i]),
                    temperatures[i]);
        }

        return new WeatherDTO(
                selectedCountry,
                selectedCity,
                weatherDataMap,
                weatherInfo.hourly_units().get(temperatureIdentifier));
    }
}
