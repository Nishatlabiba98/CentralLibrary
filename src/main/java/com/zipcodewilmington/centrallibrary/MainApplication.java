package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;
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
    
    List<LibraryItem> results = new ArrayList<>();
    for (LibraryItem item : library.search(keyword)) {
        if (item.getItemType().equalsIgnoreCase(type)) {
            results.add(item);
        }
    }

    while (true) {
        // show current results
        if (results.isEmpty()) {
            System.out.println("No " + type + " found.");
        } else {
            System.out.println("\n=== " + type + " Results (" + results.size() + " found) ===");
            for (int i = 0; i < results.size(); i++) {
                LibraryItem item = results.get(i);
                System.out.println((i + 1) + ". " + item.getTitle()
                    + " | " + (item.isAvailable() ? "Available" : "Checked Out"));
            }
        }

        // prompt for next action
        System.out.println("\nOptions:");
        System.out.println("  S - Search further");
        System.out.println("  R - Reset search");
        System.out.println("  X - Back to main menu");
        System.out.print("Choose: ");
        String choice = scanner.nextLine().trim().toUpperCase();

        switch (choice) {
            case "S":
                System.out.print("Enter keyword to narrow down: ");
                String narrow = scanner.nextLine();
                List<LibraryItem> narrowed = new ArrayList<>();
                for (LibraryItem item : results) {
                    if (item.matchesKeyword(narrow)) {
                        narrowed.add(item);
                    }
                }
                results = narrowed;
                break;
            case "R":
                System.out.print("Enter new search keyword: ");
                String reset = scanner.nextLine();
                results = new ArrayList<>();
                for (LibraryItem item : library.search(reset)) {
                    if (item.getItemType().equalsIgnoreCase(type)) {
                        results.add(item);
                    }
                }
                break;
            case "X":
                return;
            default:
                System.out.println("Invalid option, try again.");
        }
    }
}


    private void borrowItem() {
        System.out.println("Enter member ID");
        String memberId = scanner.nextLine();
        System.out.println("Enter item ID:");
        String itemId = scanner.nextLine();
        
        LibraryMember member = findMember(memberId);
        LibraryItem item = findItem(itemId);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        if (item == null) {
            System.out.println("Item not found.");
            return;
        }
    
        library.borrowItem(member, item);

    }
    private void returnItem() {
        System.out.println("Enter member ID");
        String memberId = scanner.nextLine();
        System.out.println("Enter item ID:");
        String itemId = scanner.nextLine();
        
        LibraryMember member = findMember(memberId);
        LibraryItem item = findItem(itemId);

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }
        if (item == null) {
            System.out.println("Item not found.");
            return;
        }
    
        library.returnItem(member, item);

    }

    private void payFees() {
        System.out.println("Enter member ID:");
        String memberId = scanner.nextLine();

        LibraryMember member = library.getMembers().stream()
            .filter(m -> m.getMemberId().equals(memberId))
            .findFirst().orElse(null);

        if (member == null) { System.out.println("Member not found."); return; }

        System.out.println("Outstanding fees: $" + member.getOutstandingFees());
        System.out.println("Enter amount to pay:");
        double amount = Double.parseDouble(scanner.nextLine());
        member.payFees(amount);
        System.out.println("Paid! Remaining fees: $" + member.getOutstandingFees());
    }

    private LibraryMember findMember(String memberId) {
        for (LibraryMember m : library.getMembers()) {
            if (m.getMemberId().equalsIgnoreCase(memberId)) return m;
        }
        return null;
    }

    private LibraryItem findItem(String itemId) {
        for (LibraryItem i : library.getItems()) {
            if (i.getId().equalsIgnoreCase(itemId)) return i;
        }
        return null;
    }
}
