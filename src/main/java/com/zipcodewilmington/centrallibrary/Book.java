package com.zipcodewilmington.centrallibrary;

public class Book extends LibraryItem {
    
    private String author;
    private String genre;
    private String publicationDate;
    private int pages;

    public Book(String id, String title, String location, String author, String genre, String publicationDate, int numberOfPages) {
        super(id, title, location);
        this.author = author;
        this.genre = genre;
        this.publicationDate = publicationDate;
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

    public String getpublication() {
        return publicationDate;
    }
    
    public void serpublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
        
    }

    @Override
    public String[] getSearchableFields() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSearchableFields'");
    }
}

