package com.zipcodewilmington.centrallibrary;


import org.junit.Assert;
import org.junit.Test;


public class PersonTest {

    @Test
    public void testPersonConstructorAndGetters() {
        // given
        String name = "Joe";
        int age = 30;
        String email = "joeschmo@gmail.com";
        String phoneNumber = "302-555-1111";

        // when
        Person person = new Person(name, age, email, phoneNumber);

        Assert.assertEquals(name, person.getName());
        Assert.assertEquals(phoneNumber, person.getPhoneNumber());
        Assert.assertEquals(email, person.getEmail());
        Assert.assertEquals(age, person.getAge());
    }
    @Test
    public void testSetAge_negativeAge_throwsException() {
        Person person = new Person("Joe", 30, "joeschmo@gmail.com", "123-456-7890");
    }
}
