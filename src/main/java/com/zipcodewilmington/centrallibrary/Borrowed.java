package com.zipcodewilmington.centrallibrary;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Borrowed {
    private LibraryMember member;
    private LibraryItem item;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public Borrowed(LibraryMember member, LibraryItem item) {
        this.member = member;
        this.item = item;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(item.getMaxBorrowDays());
    }

    public LibraryMember getMember() {
        return member;
    }

    public LibraryItem getItem() {
        return item;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public int getDaysLate() {
        LocalDate today = LocalDate.now();
        if (today.isAfter(dueDate)) {
            return (int) ChronoUnit.DAYS.between(dueDate, today);
        }
        return 0;
    }

    public double calculateLateFee() {
        return item.calculateLateFee(getDaysLate());
    }

    public boolean isOverdue() {
        return getDaysLate() > 0;
    }

    @Override
    public String toString() {
        return member.getName() + " borrowed " + item.getTitle()
            + " | Due: " + dueDate
            + " | Days Late: " + getDaysLate()
            + " | Late Fee: $" + calculateLateFee();
    }
}
