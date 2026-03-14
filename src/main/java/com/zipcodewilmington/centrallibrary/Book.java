package com.zipcodewilmington.centrallibrary;

public class Book extends LibraryItem implements Reservable {
    
    private String author;
    private String genre; 
    private int pages;
    private String isbn;
    private String publicationDate;
    private boolean isReserved;
    private LibraryMember reservedBy;

    public Book(String id, String title, String location, String author, String isbn, int numberOfPages, String genre, String publicationDate) {
        super(id, title, location);
        this.author = author;
        this.genre = genre;
        this.pages = numberOfPages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
        return new String[]{getTitle(), author, genre, isbn, publicationDate};
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
    public LibraryMember getReservedBy() {
        return reservedBy;
    }
}

