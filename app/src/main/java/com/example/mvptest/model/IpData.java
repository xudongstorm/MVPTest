package com.example.mvptest.model;

public class IpData {

    private String country;
    private String city;
    private String area;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
