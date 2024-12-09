package org.example.systemManagment.entity;

import org.example.systemManagment.library.LibraryItem;
import org.example.systemManagment.library.observer.EventManager;
import org.example.systemManagment.library.observer.Observer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Book extends LibraryItem implements EventManager {

    private Status status;
    private Date returnDate ;
    private final List<Observer> observers = new ArrayList<>();


    @Override
    public void display() {
        System.out.println("author : " + getAuthor());
        System.out.println("title : " + getTitle());
        System.out.println("status : " + getStatus());
    }

    public Book(){}

    public Book(int id, String title, String author, Date year, LibraryItemType type, Status status, Date returnDate) {
      super(id, title, author, year, type);
        this.status = status;
        this.returnDate = returnDate;

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

    public enum Status {
        EXIST,
        BORROWED,
        BANNED
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
        if (status == Status.EXIST) {
            execute();
        }
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
