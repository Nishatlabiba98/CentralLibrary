package com.zipcodewilmington.centrallibrary;

import java.util.ArrayList;
import java.util.List;

public abstract class Library {
    private String name;
    private String address;
    private List<LibraryItem> items;
    private List<LibraryMember> members;
    private List<Librarian> librarians;
    
    
    public Library(String name, String address) {
        this.name = name;
        this.address = address;
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.librarians = new ArrayList<>();
    }

    public String getname() {
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
}
