package com.library;

import com.library.controller.Menu;

import java.util.Scanner;

import static com.library.controller.ProcessChoice.processChoice;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int choice = Menu.showMenu(scanner);
            if (!processChoice(choice)) {
                break;
            }
        }
        scanner.close();
    }
}