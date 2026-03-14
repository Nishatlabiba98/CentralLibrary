package com.zipcodewilmington.centrallibrary;

public class DVDTest {
// Base class (superclass) DVD
public abstract class DVD extends LibraryItem implements Reservable {
    public DVD(String id, String title, String location) {
        super(id, title, location);
    
    }

    private String title;
    private String director;
    private String duration;
    private String rating;
    private String genre;
    private boolean borrowed;

    public String getTitle() {
        return title;
}

    public String getDirector() {
    return director;
    }

    public String getGenre() {
    return genre;
    }

public String getRating() {
    return rating;
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
    
    public String[] getSearchableFields() { 
        return new String[]{getTitle(), director, genre};
    }
}

}
