package com.library.repository.DTO;

import java.util.Date;

public class LibraryItemRequestDTO {

    private int id;
    private String title;
    private String author;
    private Date year;
    private String libraryItemType;
    private String extraInfo;

    public LibraryItemRequestDTO(int id, String title, String author, Date year, String libraryItemType, String extraInfo) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.libraryItemType = libraryItemType;
        this.extraInfo = extraInfo;
    }

    public LibraryItemRequestDTO() {
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

    public String getLibraryItemType() {
        return libraryItemType;
    }

    public void setLibraryItemType(String libraryItemType) {
        this.libraryItemType = libraryItemType;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
}
