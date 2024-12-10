package com.library.model;

import java.util.Date;

public class Magazine extends LibraryItem {

    private String genre;

    public Magazine(int id, String title, String author, Date year, LibraryItemType type, String genre) {
        super(id, title, author, year, type);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public void display() {
        System.out.println("author : " + getAuthor());
        System.out.println("title : " + getTitle());
        System.out.println("genre : " + getGenre());
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year='" + getYear() + '\'' +
                ", genre='" + getGenre() + '\'' +
                '}';
    }
}
