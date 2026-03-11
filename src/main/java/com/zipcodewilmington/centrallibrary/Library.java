package com.zipcodewilmington.centrallibrary;

import java.util.Scanner;

public class Library {
    
    public static String name(String libraryNameString) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(libraryNameString);
        String userInput = scanner.nextLine();
        return userInput;
    }

    

}
