package com.alevel.ORM.data;

public class Address {
    private String city;
    private String street;
    private String house;
    private String extra;

    public Address() {
    }

    public Address(String city, String street, String house) {
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public Address(String city, String street, String house, String extra) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.extra = extra;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
}
