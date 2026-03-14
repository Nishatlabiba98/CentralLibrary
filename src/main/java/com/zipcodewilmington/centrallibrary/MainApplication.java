package com.zipcodewilmington.centrallibrary;

import java.util.Scanner;

public class MainApplication {
    private Library library;
    private Scanner scanner;

    public MainApplication(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }
public void start() {
        System.out.println("Welcome to the Central Library!");
        boolean running = true;

        while (running) {
            System.out.println("\n==== MAIN MENU ====");
            System.out.println("1. Search Books");
            System.out.println("2. Search Periodicals");
            System.out.println("3. Search DVDs");
            System.out.println("4. Search Movies");
            System.out.println("5. Search Music");
            System.out.println("6. Display All Items");
            System.out.println("7. Borrow an Item");
            System.out.println("8. Return an Item");
            System.out.println("9. Pay Fees");
            System.out.println("10. Generate Late Fee Report");
            System.out.println("11. Exit");
            System.out.println("Choose an option:");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    searchByType("Book");
                    break;
                case "2":
                    searchByType("Periodical");
                    break;
                case "3":
                    searchByType("DVD");
                    break;
                case "4":
                    searchByType("Movie");
                    break;
                case "5":
                    searchByType("Music");
                    break;
                case "6":
                    library.displayAllItems();
                    break;
                case "7":
                    borrowItem();
                    break;
                case "8":
                    returnItem();
                    break;
                case "9":
                    payFees();
                    break;
                case "10":
                    library.generateLateFeeReport();
                    break;
                case "11":
                    System.out.println("bye bye");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                }
            }
            scanner.close();
    }

    private void searchByType(String type) {
        System.out.println("Enter a keyword to search:");
        String keyword = scanner.nextLine();
        library.search(keyword).stream()
            .filter(item -> item.getItemType().equalsIgnoreCase(type))
            forEach(item -> System.out.println(item.getItemType() + " | " + item.getTitle()));
    }

    private void borrowItem() {
        System.out.println("Enter member ID");
        String memberId = scanner.nextLine();
        System.out.println("Enter item ID:");
        String itemId = scanner.nextLine();
        
        LibraryMember member = library.getMembers().stream()
            .filter(m -> m.getMemberId()equals(memberId))
            .findFirst().orElse(null);
        LibraryItem item = library.getItems().stream()
            .filter(i -> i.getId().equals(itemId))
            .findFirst().orElse(null);

        if (member == null) {
            System.err.println("Member not found.");
            return;
        }
        if (item == null) {
            System.err.println("Item not found.");
            return;
        }
    
        library.borrowItem(member, item);

    }
    private void returnItem() {
        System.out.println("Enter member ID");
        String memberId = scanner.nextLine();
        System.out.println("Enter item ID:");
        String itemId = scanner.nextLine();
        
        LibraryMember member = library.getMembers().stream()
            .filter(m -> m.getMemberId()equals(memberId))
            .findFirst().orElse(null);
        LibraryItem item = library.getItems().stream()
            .filter(i -> i.getId().equals(itemId))
            .findFirst().orElse(null);

        if (member == null) {
            System.err.println("Member not found.");
            return;
        }
        if (item == null) {
            System.err.println("Item not found.");
            return;
        }
    
        library.returnItem(member, item);

    }



    private void viewAllItems() {
        library.getAllItems().forEach(item -> System.out.println(item.getTitle()));
    }

}
