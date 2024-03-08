package com.n11.assignment3.service;

import com.n11.assignment3.entity.City;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class CityService {

    private List<City> cities;

    public CityService() {
        cities = new ArrayList<>();
        loadCitiesFromCSV("World_Cities_Location_table.csv");
    }

    private void loadCitiesFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length != 6) {
                    System.err.println("Geçersiz veri satırı: " + line);
                    continue;
                }
                City city = new City();
                city.setId(Long.parseLong(parts[0].replace("\"", "").trim()));
                city.setCountry(parts[1].replace("\"", "").trim());
                city.setCityName(parts[2].replace("\"", "").trim());
                city.setLatitude(Double.parseDouble(parts[3].replace("\"", "").trim()));
                city.setLongitude(Double.parseDouble(parts[4].replace("\"", "").trim()));
                city.setPopulation((long) Double.parseDouble(parts[5].replace("\"", "").trim()));
                cities.add(city);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public double[] retrieveCoordinatesByCityAndCountry(String cityName, String country) {
        double[] coordinates = new double[2];
        for (City city : cities) {
            if (city.getCityName().equalsIgnoreCase(cityName) && city.getCountry().equalsIgnoreCase(country)) {
                coordinates[0] = city.getLatitude();
                coordinates[1] = city.getLongitude();
                return coordinates;
            }
        }
        return coordinates;
    }
}
