package com.zipcodewilmington.centrallibrary;

public class BookTest {

public static void main(String[] args) {

    Book book = new Book("A100", "The Great Gatsby", "Aisle 3", 180); 
    

    System.out.println(book.getAuthor());
    System.out.println(book.getGenre());
    System.out.println(book.getPages());
    System.out.println(book.isAvailable());
    System.out.println(book.getLocation());
    System.out.println(book.getId());
    System.out.println(book.getTitle());
    
}


}
