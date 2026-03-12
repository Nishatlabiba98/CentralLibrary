package com.zipcodewilmington.centrallibrary;

public class DVDTest {
// Base class (superclass) DVD
public abstract class DVD extends LibraryItem implements Reservable {
    private String Title;
    private String Director;
    private String Duration;
    private String Rating;
    private String Genre;
    private boolean Borrowed;

    public String getTitle() {
        return Title;
}

    public String getDirector() {
    return Director;
    }

    public String getGenre() {
    return Genre;
    }

public String getRating() {
    return Rating;
}

    public interface Reserveable {
    void reserve(String user);
    boolean isReserved();
}


    public String getType() {
    return "DVD";
}


    public int getBorrowedDays() {
    return 7;
    }   


    public double getLateFeePerDay() {
    return 1.00;
    }   

}
}
