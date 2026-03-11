package com.zipcodewilmington.centrallibrary;



public class Address{
    private String street;
    private String city;
    private String state;
    private String zipcode;

    public Address(String street, String city, String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String getStreet() {return street; }
    public String getCity() {return city; }
    public String getState() {return state; }
    public String getZipcode() {return zipcode; }

    public void SetStreet(String street) {this.street = state; }
    public void SetCity(String city) {this.city = city; }
    public void SetState(String state) {this.state = state; }
    public void SetZipcode(String zipCode) {this.zipcode = zipCode; }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + ", " + zipcode; 
    }
}