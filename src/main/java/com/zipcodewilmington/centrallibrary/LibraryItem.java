package com.zipcodewilmington.centrallibrary;

public abstract class LibraryItem {
    private int id;
    private String title;
    private String location;
    private boolean isAvailable;

    public LibraryItem(int id, String title, String location){
        this.id = id;
        this.title = title;
        this.location = location;
        this.isAvailable = true;

        
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void checkOut() {
        this.isAvailable = false;
    }

    public void checkIn() {
        this.isAvailable = true;

    } 

    public abstract double calculateLateFee(int daysLate);
    public abstract int getMaxBorrowDays();
    public abstract String getItemType();

}
