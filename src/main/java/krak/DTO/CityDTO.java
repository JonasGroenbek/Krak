package krak.dto;

import krak.entities.Cityinfo;

public class CityDTO {

    private int zipCode;
    private String city;

    public CityDTO(Cityinfo city) {
        this.zipCode = city.getZip();
        this.city = city.getCity();
    }
}
