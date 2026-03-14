package com.zipcodewilmington.centrallibrary;

public class Person {
    private String name;
    private String email;
    private String phoneNumber;
    private int age;
    //constructor initialized variable instances that belong to the person class

    public Person(String name, int age, String email, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
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


    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative.");
        this.age = age;
}
}
