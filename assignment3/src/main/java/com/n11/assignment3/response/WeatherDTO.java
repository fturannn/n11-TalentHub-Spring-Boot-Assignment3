package com.n11.assignment3.response;

import java.time.LocalDateTime;
import java.util.Map;

public record WeatherDTO(
        String selectedCountry,
        String selectedCity,
        Map<LocalDateTime, String> weatherDataMap,
        String unit
) {
}
