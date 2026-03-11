package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

public abstract class Library {
    private String name;
    private Address address;
    private List<LibraryItem> items;
    private List<LibraryMember> members;
    private List<Librarian> librarians;
    
    
    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.librarians = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public Address getAddress() {
        return address;
    }
    public List<LibraryItem> getItems() {
        return items;
    }
    public List<LibraryMember> getMembers() {
        return members;
    }
    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }
    public void removeItem(LibraryItem item) {
        items.remove(item);
    }
    public void addMember(LibraryMember member) {
        members.add(member);
    }
    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    public List<LibraryItem> search(String keyword) {
        List<LibraryItem> results = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item.matchesKeyword(keyword)) {
                results.add(item);
            }
        }
        return results;
    }
    public void displayAllItems() {
        for (LibraryItem item : items) {
            System.out.println(item.getItemType() + " | " + item.getTitle() + " | " + (item.isAvailable() ? "Available" : "Checked Out"));
        }
    }
    
    public void generateLateFeeReport() {
        for (LibraryMember member : members) {
            System.out.println("Member: " + member.getName());
            for (LibraryItem item : member.getBorrowedItems()) {
                System.out.println("  - " + item.getTitle() 
                    + " | Max Days: " + item.getMaxBorrowDays()
                    + " | Daily Fee: $" + item.calculateLateFee(1));
            }
        }
    }
}
