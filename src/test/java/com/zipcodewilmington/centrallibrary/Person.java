package com.github.zipcodewilmington.sample;

public class Person {
}

public class Address{
    //Instance vairables
    private String street;
    private String city;
    private String state;
    private String zipCode;

    //Defalut Setting
public Address() {
    this.street = "";
    this.city = "";
    this.state = "";
    this.zipCode = "";
    }

    //Parameterized Constructor
    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    //Getter
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getZipcode() {
        return zipCode;
    }
    //Override for cleaner view
    public String toString() {
        return street + ", " + city + ", " + state + " " + zipCode;
    }
} 

