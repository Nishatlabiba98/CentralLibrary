
package com.zipcodewilmington.centrallibrary;

public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private int age;
    private String email;

    public Person(String name, String address, String phoneNumber, int age, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        setAge(age);
        this.email = email;
    }

    public String getName() {return name; }
    public String getAddress() {return address; }
    public String getPhoneNumber() {return phoneNumber; }
    public int getAge() {return age; }
    public String getEmail() {return email;}

    public void setName(String name) {this.name = name; }
    public void setAddress(String address) {this.address = address; }
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }
    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative.");
        this.age = age; 
    }
    public void setEmail(String email) {this.email = email; }

    @Override
    public String toString() {
        return name + ", " + address + ", " + phoneNumber + ", " + age + ", " + email; 
    }
}

