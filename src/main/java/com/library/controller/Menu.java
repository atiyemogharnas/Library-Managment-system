package com.library.controller;

import java.util.Scanner;

public class Menu {

    public static int showMenu(Scanner scanner) {
        System.out.println("\nMenu:");
        System.out.println("1. create item");
        System.out.println("2. update item");
        System.out.println("3. delete item");
        System.out.println("4. display item");
        System.out.println("5. display all item");
        System.out.println("6. sort items by field");
        System.out.println("7. search items by word");
        System.out.println("8. Borrowing Book");
        System.out.println("9. return Book");
        System.out.println("10. show status Book");
        System.out.println("11. search by title");
        System.out.println("12. search by year");
        System.out.println("13. serialize or deserialize");
        System.out.println("14. check multi threaded ");
        System.out.println("0. exit ");

        System.out.print("Select an option (0 to exit): ");
        int choice = -1;

        while (choice < 0 || choice > 15) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > 15) {
                    System.out.println("Invalid choice. Please enter a number between 0 and 20.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return choice;
    }
}
