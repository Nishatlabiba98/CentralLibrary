package com.zipcodewilmington.centrallibrary;

public class Book extends LibraryItem {
    
    private String author;
    private String genre; // move this also remove the getter and setter of isbn
    private int pages;

    public Book(String id, String title, String location, String author, String genre, String publicationDate, String isbn, int numberOfPages) {
        super(id, title, location);
        this.author = author;
        this.genre = genre;
        this.pages = numberOfPages;
        //implement searchable fields
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

    public String[] getSearchableFields() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSearchableFields'");
    }
}

