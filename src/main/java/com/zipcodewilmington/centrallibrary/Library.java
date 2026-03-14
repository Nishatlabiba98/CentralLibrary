package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private Address address;
    private List<LibraryItem> items;
    private List<LibraryMember> members;
    private List<Librarian> librarians;
    private List<Borrowed> borrowedRecords;
    
    
    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.librarians = new ArrayList<>();
        this.borrowedRecords = new ArrayList<>();
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

    public List<LibraryMember> searchMembers(String keyword) {
        List<LibraryMember> results = new ArrayList<>();
        for (LibraryMember member : members) {
        if (member.getName().toLowerCase().contains(keyword.toLowerCase()) ||
            member.getMemberId().toLowerCase().contains(keyword.toLowerCase())) {
            results.add(member);
        }
    }
    return results;
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

    public void borrowItem(LibraryMember member, LibraryItem item) {
        if (!item.isAvailable()) {
            System.out.println(item.getTitle() + " is not available.");
            return;
        }
        member.borrowItem(item);
        borrowedRecords.add(new Borrowed(member, item));
        System.out.println(member.getName() + " borrowed " + item.getTitle());
    }


    public void returnItem(LibraryMember member, LibraryItem item) {
        Borrowed record = null;
        for (Borrowed b : borrowedRecords) {
            if (b.getMember().equals(member) && b.getItem().equals(item)) {
                record = b;
                break;
            }
        }
        if (record == null) {
            System.out.println("No borrow record found.");
            return;
        }
        member.returnItem(item, record.getDaysLate());
        borrowedRecords.remove(record);
        System.out.println(member.getName() + " returned " + item.getTitle()
            + " | Late Fee: $" + record.calculateLateFee());
    }

    public void generateLateFeeReport() {
        System.out.println("=== Late Fee Report ===");
        for (Borrowed b : borrowedRecords) {
            if (b.isOverdue()) {
                System.out.println(b.toString());
            }
        }
    }
    public List<Borrowed> getBorrowedRecords() { return borrowedRecords; }
}

    


