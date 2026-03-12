package com.zipcodewilmington.centrallibrary;

public class Movie extends LibraryItem {
    private String director;
    private String duration;
    private String rating;
    private String genre; 

public Movie(String  id, String title, String location, String director,     String duration, String rating, String genre) {
        super(id, title, location);
        this.director = director;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;

    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }
    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1.00;
    }

    @Override
    public int getMaxBorrowDays() {
        return 7;
    }
    @Override
    public String getItemType() {
        return "Movie";
    }
    
    @Override
    public String[] getSearchableFields() { 
        return new String[]{getTitle(), director, duration, rating, genre};
    }
}
