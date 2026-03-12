package com.zipcodewilmington.centrallibrary;
import java.util.ArrayList;
import java.util.List;
 
public class LibraryMember extends Person{
    private String memberId;
    private double outstandingFees;
    private String membershipDate;
    private List<LibraryItem> borrowedItems;
    private Address address;
    
    public LibraryMember(String name, int age, String email, String phoneNumber, String memberId, Address address) {
        super(name, age, email, phoneNumber);
        setMemberId(memberId);
        this.membershipDate = membershipDate;
        this.borrowedItems = new ArrayList<>();
        this.outstandingFees = 0.0;
        this.address = address;
    }
    public String getMemberId() {
        return memberId;
    }
    public String getMembershipDate() {
        return membershipDate;
}
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
    public double getOutstandingFees() {
        return outstandingFees;
    }
    public Address getAddress() {
        return address;
    }

    public void setMemberId(String memberId) {
        if (memberId == null || memberId.trim().isEmpty()) {
            throw new IllegalArgumentException("Member ID cannot be null or empty.");
        }
        this.memberId = memberId;
    }

    public void setAddress(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null.");
        }
        this.address = address;
    }

    public void borrowItem(LibraryItem item) {
        if (!item.isAvailable())
            throw new IllegalStateException(item.getTitle() + " is not available.");
            item.checkOut();
            borrowedItems.add(item);
            System.out.println(getName() + " borrowed: " + item.getTitle());
    }
    public void returnItem(LibraryItem item, int daysLate) {
        item.checkIn();
        borrowedItems.remove(item);
        double fee = item.calculateLateFee(daysLate);
        outstandingFees += fee;
        System.out.println(getName() + " returned: " + item.getTitle() + " | Late Fee: $" + fee);
    }
    public void payFees(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive.");
        }
        if (amount > outstandingFees) {
            throw new IllegalArgumentException("Payment exceeds outstanding fees.");
        }
        outstandingFees -= amount;
        System.out.println(getName() + " paid: $" + amount + " | Remaining Fees: $" + outstandingFees);

    }
@Override
public String toString() {
        return "LibraryMember{name='" + getName() + "', memberId='" + memberId +
"', outstandingFees=" + outstandingFees + ", address=" + address + "}";
}
}