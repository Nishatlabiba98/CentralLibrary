package com.zipcodewilmington.centrallibrary;

public class DVD extends LibraryItem implements Reservable {

    private String director;
    private String duration;
    private String rating;
    private String genre;
    private boolean isReserved;
    private LibraryMember reservedBy;
    

    public DVD(String id, String title, String location, String director, String duration, String rating, String genre) {
        super(id, title, location);
        this.director = director;
        this.duration = duration;
        this.rating = rating;
        this.genre = genre;
        this.isReserved = false;
    }
    


    public String getDirector() {
    return director;
    }
    public void setDirector(String director) {this.director = director;}

    public String getDuration()
    {return duration;}
    public void setDuration(String duration) { this.duration = duration;}

    public String getRating() {
    return rating;
    }
    public void setRating(String rating) { this.rating = rating;}

    
    public String getGenre() {
    return genre;
    }
    public void setGenre(String genre) { this.genre = genre;}

    public LibraryMember getReservedBy()
    { return reservedBy; }

    @Override
    public int getMaxBorrowDays() {
    return 7;
    }   
    @Override
    public double calculateLateFee(int daysLate) {
    return daysLate * 1.00;
    }
    @Override
    public String getItemType() {
    return "DVD";
    }

    @Override
    public String[] getSearchableFields() { 
        return new String[]{getTitle(), director, genre};
    }


    @Override
    public void reserve(LibraryMember member) {
        if (isReserved) throw new IllegalStateException(getTitle() + " is already reserved.");
        isReserved = true;
        reservedBy = member;
    }
    
    @Override
    public void cancelReserve(LibraryMember member) {
    isReserved = false;
    reservedBy = null;
    }
    
    @Override
    public boolean isReserved() {
        return isReserved; 
    }
}


