package org.example.systemManagment.entity;

import org.example.systemManagment.library.LibraryItem;


public class Book extends LibraryItem {

    private Status status;

    @Override
    public void display() {
        System.out.println("author : " + getAuthor());
        System.out.println("title : " + getTitle());
        System.out.println("status : " + getStatus());
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
}
