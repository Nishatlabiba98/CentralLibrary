package com.zipcodewilmington.centrallibrary;


public interface Reservable {
    void reserve(LibraryMember member);
    void cancelReserve(LibraryMember member);
    boolean isReserved();

}
