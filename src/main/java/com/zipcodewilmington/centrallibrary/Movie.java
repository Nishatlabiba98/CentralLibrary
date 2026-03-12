package com.zipcodewilmington.centrallibrary;

public class Movie extends LibraryItem {
    private String director;
    private int duration;
    private String rating;
    private String genre; 
    public Movie(String  id, String title, String location, String director, int duration, String rating, String genre) {
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

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
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

    public String[] getSearchableFields() {
        return new String[]{getTitle(), director, genre, rating};
    }
    // add in the rating 
    
}
