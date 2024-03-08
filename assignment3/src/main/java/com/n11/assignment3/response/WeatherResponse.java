package com.n11.assignment3.response;

import java.util.Map;

public record WeatherResponse(
        Double latitude,
        Double longitude,
        String generationtime_ms,
        Long utc_offset_seconds,
        String timezone,
        String timezone_abbreviation,
        String elevation,
        Map<String, String[]> hourly,
        Map<String, String> hourly_units
) {
}
