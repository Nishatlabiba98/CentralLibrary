package com.zipcodewilmington.centrallibrary;

public abstract class DVD extends LibraryItem implements Reservable {
    private String director;
    private String duration;
    private String rating;
    private String genre;
    private boolean isReserved;
    

    public DVD(String id, String title, String location, String director, String duration, String rating, String genre) {
        super(id, title, location);
        this.director = director;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;
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


    public String getType() {
    return "DVD";
    }


    public int getBorrowedDays() {
    return 7;
    }   


    public double getLateFeePerDay() {
    return 1.00;
    }   

    @Override
    public String[] getSearchableFields() { 
        return new String[]{getTitle(), director, duration, rating, genre};
    }
}