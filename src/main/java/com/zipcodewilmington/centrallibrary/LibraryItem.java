package com.zipcodewilmington.centrallibrary;

public abstract class LibraryItem implements Searchable {
    private String id;
    private String title;
    private String location;
    private boolean isAvailable;
    private String isbn;
    

//constructor
    public LibraryItem() {

    }

    public LibraryItem(String id, String title, String location){
        this.id = id;
        this.title = title;
        this.location = location;
        this.isAvailable = true;
        
    }

    

    public String getId() {
        return id;
    }
    public void setId(String id) {
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
        if (!isAvailable) throw new IllegalStateException(title + " is already checked out.");
        this.isAvailable = false;
        
    }

    public void checkIn() {
        this.isAvailable = true;

    } 
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean matchesKeyword(String keyword) {
    for (String field : getSearchableFields()) {
        if (field != null && field.toLowerCase().contains(keyword.toLowerCase())) {
            return true;
        }
    }
    return false;
    }
}
