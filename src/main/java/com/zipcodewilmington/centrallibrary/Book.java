package com.zipcodewilmington.centrallibrary;

public class Book extends LibraryItem {
    
    private String author;
    private String genre; 
    private int pages;

    public Book(String id, String title, String location, String author, String genre, String publicationDate, String isbn, int numberOfPages) {
        super(id, title, location);
        this.author = author;
        this.genre = genre;
        this.pages = numberOfPages;
        
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;

    }

    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
        
    }
    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 0.50;
    }

    @Override
    public int getMaxBorrowDays() {
        return 14;
    }
    @Override
    public String getItemType() {
        return "Book";
    }

    @Override
    public String[] getSearchableFields() {
        return new String[]{getTitle(), author, genre};
    }
}

