package org.example.systemManagment.library;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public abstract class LibraryItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private String author;
    private Date year;
    private LibraryItemType type;


    public enum LibraryItemType {
        BOOK,
        MAGAZINE,
        THESIS,
        REFRENCE
    }

    public LibraryItem(int id, String title, String author, Date year, LibraryItemType type) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.type = type;
    }

    public LibraryItem() {
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

    public Date getYear() {
        return year;
    }

    public void setYear(Date year) {
        this.year = year;
    }

    public LibraryItemType getType() {
        return type;
    }

    public void setType(LibraryItemType type) {
        this.type = type;
    }

    public abstract void display();

}
