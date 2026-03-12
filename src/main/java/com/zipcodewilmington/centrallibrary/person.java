package com.zipcodewilmington.centrallibrary;

public class Person {
    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    //constructor initialized variable instances that belong to the person class

    public Person(String name, int age, String phoneNumber, String email) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public Person() {
        
    }
    //getters and setters for the person class
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }
        this.phoneNumber = phoneNumber;
}
@Override
    public String toString() {
        return "person" +  "name='" + name + '\'' + ", email='" + email + '\'' +  ", phoneNumber='" + phoneNumber + '\'' + ", age=" + age +'}';
    }


    void setAge(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
