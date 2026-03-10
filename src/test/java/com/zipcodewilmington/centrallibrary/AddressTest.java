package com.zipcodewilmington.centrallibrary;

import org.junit.Assert;
import org.junit.Test;

public class AddressTest {
    
    @Test
    public void testAddressConstructorAndGetters() {
        // given
        String street = "Joe";
        String city = "302-555-1111";
        String state = "joeschmo@gmail.com";
        String zipcode = "";

        // when
        Address address = new Address (street, city, state,zipcode);

        Assert.assertEquals(street, address.getStreet());
        Assert.assertEquals(city, address.getCity());
        Assert.assertEquals(state, address.getState());
        Assert.assertEquals(zipcode, address.getZipcode());
    }

}
