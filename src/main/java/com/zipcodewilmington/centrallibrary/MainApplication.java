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
            System.out.println("3. Search Movies");
            System.out.println("4. Search Music");
            System.out.println("5. Display All Items");
            System.out.println("6. Borrow an Item");
            System.out.println("7. Return an Item");
            System.out.println("8. Pay Fees");
            System.out.println("9. Generate Late Fee Report");
            System.out.println("10. Exit");
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
                    searchByType("Movie");
                    break;
                case "4":
                    searchByType("Music");
                    break;
                case "5":
                    library.displayAllItems();
                    break;
                case "6":
                    borrowItem();
                    break;
                case "7":
                    returnItem();
                    break;
                case "8":
                    payFees();
                    break;
                case "9":
                    library.generateLateFeeReport();
                    break;
                case "10":
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
        library.search(keyword).forEach(item -> System.out.println(item.getTitle()));
    }

    private void viewAllItems() {
        library.getAllItems().forEach(item -> System.out.println(item.getTitle()));
    }

}
