package com.zipcodewilmington.centrallibrary;

public abstract class Book extends LibraryItem {

    private String author;
    private String genre;
    private String publicationDate;
    private int pages;

    public Book(String author, String genre, String publicationDate, int numberOfPages) {
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
}

//lofi
//lofi