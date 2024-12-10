package com.library.model;

import com.library.patterns.observer.EventHandler;
import com.library.patterns.observer.Observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Book extends LibraryItem implements EventHandler {

    private Status status;
    private Date returnDate;
    private final List<Observer> observers = new ArrayList<>();
    private Integer numberOfBook = 0;

    @Override
    public void display() {
        System.out.println("author : " + getAuthor());
        System.out.println("title : " + getTitle());
        System.out.println("status : " + getStatus());
    }

    public Book(int id, String title, String author, Date year, LibraryItemType type, Status status) {
        super(id, title, author, year, type);
        this.status = status;

    }

    public enum Status {
        EXIST,
        BORROWED,
        BANNED
    }

    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void execute() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public Integer getNumberOfBook() {
        return numberOfBook;
    }

    public void setNumberOfBook(Integer numberOfBook) {
        this.numberOfBook = numberOfBook;
    }

    public Status getStatus() {
        return status;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year='" + getYear() + '\'' +
                ", status='" + getStatus() + '\'' +
                '}';
    }
}
