package com.n11.assignment3.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
    private String cityName;
    private String cityAscii;
    private double latitude;
    private double longitude;
    private String country;
    private String iso2;
    private String iso3;
    private String adminName;
    private String capital;
    private long population;
    private long id;



    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", cityAscii='" + cityAscii + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", country='" + country + '\'' +
                ", iso2='" + iso2 + '\'' +
                ", iso3='" + iso3 + '\'' +
                ", adminName='" + adminName + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", id=" + id +
                '}';
    }
}
