package com.zipcodewilmington.centrallibrary;

class LibraryMember {

}
public interface Reservable {
    void reserve(LibraryMember member);
    void cancelReserve(LibraryMember member);
    boolean isReserved();

}
