package com.zipcodewilmington.centrallibrary;

public class Main {
    public static void main(String[] args) {

        // Set up library per README
        Address libraryAddress = new Address("123 Main St", "Alexandra", "DE", "12345");
        Library library = new Library("Central Library", libraryAddress);

        // Set up Hypatia the librarian per README
        Librarian hypatia = new Librarian(
            "Hypatia", 40, "hypatia@centrallibrary.com", "555-0001",
            "L001", "General", 45000
        );
        library.addLibrarian(hypatia);

        // Load items from JSON files
        JSONLoader loader = new JSONLoader();
        loader.loadBooks().forEach(library::addItem);
        loader.loadPeriodicals().forEach(library::addItem);
        loader.loadDVDs().forEach(library::addItem);
        loader.loadMusic().forEach(library::addItem);
        loader.loadMovies().forEach(library::addItem);

        // Add members per README
        Address aliceAddress = new Address("456 Oak St", "Bookville", "MD", "12347");
        LibraryMember alice = new LibraryMember(
            "Alice Johnson", 25, "alice@email.com", "555-1234",
            "M001", "2024-01-01", aliceAddress
        );

        Address bobAddress = new Address("654 Maple St", "Media", "PA", "12346");
        LibraryMember bob = new LibraryMember(
            "Bob Wilson", 35, "bob@email.com", "555-4321",
            "M002", "2024-01-01", bobAddress
        );

        library.addMember(alice);
        library.addMember(bob);

        // Start the CLI
        MainApplication app = new MainApplication(library);
        app.start();
    }
}