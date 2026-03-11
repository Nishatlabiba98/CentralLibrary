package com.zipcodewilmington.centrallibrary;

import org.junit.Assert;
import org.junit.Test;

public class PeriodicalTest {
    
    @Test
    public void testPeriodicalConstructorAndGetters() {
        // given
        String id = "P001";
        String title = "Cool Magazine";
        String location = "Wilmington";
        String publisher = "Pixar";
        String issn = "394851939422";
        String volume = "4";
        String issueNumber = "2"; 
        String publicationDate = "2/2/22";

        // when
        Periodical periodical = new Periodical (id, title, location, publisher, issn, volume, issueNumber, publicationDate);

        Assert.assertEquals(publisher, periodical.getPublisher());
        Assert.assertEquals(issn, periodical.getIssn());
        Assert.assertEquals(volume, periodical.getVolume());
        Assert.assertEquals(issueNumber, periodical.getIssueNumber());
        Assert.assertEquals(publicationDate, periodical.getPublicationDate());
    }

    @Test
    public void testPeriodicalLateFee() {
        // given
        Periodical periodical = new Periodical("P001", "Byte", "P1", "McGraw-Hill", "0360-5280", "6", "8", "08/01/1981");

        // then
        Assert.assertEquals(2.50, periodical.calculateLateFee(10), 0.001);
    }


    @Test
    public void testPeriodicalMaxBorrowDays() {
        // given
        Periodical periodical = new Periodical("P001", "Byte", "P1", "McGraw-Hill", "0360-5280", "6", "8", "08/01/1981");

        // then
        Assert.assertEquals(7, periodical.getMaxBorrowDays());
    }
}
