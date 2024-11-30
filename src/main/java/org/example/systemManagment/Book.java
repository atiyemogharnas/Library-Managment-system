package org.example.systemManagment;

import java.time.LocalDate;

public class Book {

    private int id;
    private String title;
    private String author;
    private LocalDate yearPublication;
    private Status status;

    public enum Status {
        EXIST,
        BORROWED,
        BANNED
    }

    public Book() {
    }

    public Book(int id, String title, String author, LocalDate yearPublication, Status status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublication = yearPublication;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(LocalDate yearPublication) {
        this.yearPublication = yearPublication;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
