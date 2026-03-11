package com.zipcodewilmington.centrallibrary;

public   class Book extends LibraryItem {
    private String author;
    private String genre;
    private String isbn;
    private int pages;

    

    public Book(String author, String genre, String isbn, int numberOfPages) {
       
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
        
    }
}

