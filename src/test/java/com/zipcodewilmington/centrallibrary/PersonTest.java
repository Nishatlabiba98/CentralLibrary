package com.zipcodewilmington.centrallibrary;


import org.junit.Test;
import org.junit.Assert;


public class PersonTest {

    @Test
    public void testPersonConstructorAndGetters() {
        // given
        String name = "Joe";
        String phoneNumber = "302-555-1111";
        String email = "joeschmo@gmail.com";
        int age = 30;

        // when
        Person person = new person(name, email, phoneNumber, age);

        Assert.assertEquals(name, person.getName());
        Assert.assertEquals(phoneNumber, person.getPhoneNumber());
        Assert.assertEquals(email, person.getEmail());
        Assert.assertEquals(age, person.getAge());
    }
    @Test
    public void testSetAge_negativeAge_throwsException() {
        Person person = new Person("Joe", 30, "joeschmo@gmail.com", "123-456-7890");

        Assert.assertThrows(IllegalArgumentException.class, () -> {
            person.setAge(-1);
        });
    }
}
