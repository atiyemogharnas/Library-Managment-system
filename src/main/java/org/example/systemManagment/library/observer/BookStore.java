package org.example.systemManagment.library.observer;

import java.util.ArrayList;
import java.util.List;

public class BookStore implements EventManager{
    private final List<Observer> observers = new ArrayList<>();
    private final List<String> availableBooks = new ArrayList<>();

    @Override
    public void execute(String bookName) {
        for (Observer observer : observers) {
            observer.update(bookName);
        }
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    public void addBook(String bookName) {
        availableBooks.add(bookName);
        System.out.println("book added: " + bookName);
        execute(bookName);
    }
}
