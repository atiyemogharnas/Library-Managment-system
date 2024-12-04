package org.example.systemManagment.entity;

import org.example.systemManagment.library.LibraryItem;

import java.util.Date;


public class Book extends LibraryItem {

    private Status status;
    private Date returnDate ;



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
