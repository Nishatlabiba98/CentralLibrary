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

}
