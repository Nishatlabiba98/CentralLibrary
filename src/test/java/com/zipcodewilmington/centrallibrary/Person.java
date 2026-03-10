package com.zipcodewilmington.centrallibrary;

public final class Person {
    private String name;
    private String phoneNumber;
    private int age;
    private String email;

    public Person(String name, int age, String email, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        setAge(age);
        this.email = email;
    }

    public String getName() {return name; }
    
    public String getPhoneNumber() {return phoneNumber; }
    public int getAge() {return age; }
    public String getEmail() {return email;}

    public void setName(String name) {this.name = name; }

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber; }
    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative.");
        this.age = age; 
    }
    public void setEmail(String email) {this.email = email; }

    @Override
    public String toString() {
        return name + ", " + phoneNumber + ", " + age + ", " + email; 
    }
}
