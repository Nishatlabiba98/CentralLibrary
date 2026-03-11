package com.zipcodewilmington.centrallibrary;


public  class LibraryItem  {
    private int id;
    private String title;
    private String location;
    private boolean isAvailable;
    private String isbn;

//constructor


    public LibraryItem() {

    }

    public LibraryItem(int id, String title, String location){
        this.id = id;
        this.title = title;
        this.location = location; 
        this.isAvailable = true;

       //getters and setters 
        
    }
    public LibraryItem(String id2, String title2, String location2) {
        
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
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

<<<<<<< HEAD:src/main/java/com/zipcodewilmington/centrallibrary/LibraryItem.java

    


=======
    
    
    public abstract String[] getSearchableFields();
>>>>>>> master:src/test/java/com/zipcodewilmington/centrallibrary/LibraryItem.java
    
    public double calculateLateFee(int daysLate) {
    return daysLate * 0.25;
    }

    
    public int getMaxBorrowDays() {
    return 7; 
}

    public String getItemType() {
    return "Periodical";
}

    

}


