package com.n11.assignment3.client;

import com.n11.assignment3.response.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weather", url = "https://api.open-meteo.com/v1")
public interface WeatherClient {

    @RequestMapping(path = "/forecast", method = RequestMethod.GET)
    WeatherResponse obtainWeatherData(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude,
                                @RequestParam("hourly") String hourlyVariables, @RequestParam("forecast_days") Integer forecastDays);
}
