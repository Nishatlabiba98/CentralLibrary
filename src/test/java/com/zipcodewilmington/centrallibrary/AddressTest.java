package com.zipcodewilmington.centrallibrary;

import org.junit.Assert;
import org.junit.Test;

public class AddressTest {
    
    @Test
    public void testAddressConstructorAndGetters() {
        // given
        String street = "123 North St.";
        String city = "Narnia";
        String state = "Fairytaleland";
        String zipcode = "12345";

        // when
        Address address = new Address (street, city, state,zipcode);

        Assert.assertEquals(street, address.getStreet());
        Assert.assertEquals(city, address.getCity());
        Assert.assertEquals(state, address.getState());
        Assert.assertEquals(zipcode, address.getZipcode());
    }

}
