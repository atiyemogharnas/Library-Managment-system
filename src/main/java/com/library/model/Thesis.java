package com.library.model;

import java.util.Date;

public class Thesis extends LibraryItem {

    public String university;

    public Thesis(int id, String title, String author, Date year, LibraryItemType type, String university) {
        super(id, title, author, year, type);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    @Override
    public void display() {
        System.out.println("author : " + getAuthor());
        System.out.println("title : " + getTitle());
        System.out.println("university : " + getUniversity());
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year='" + getYear() + '\'' +
                ", university='" + getUniversity() + '\'' +
                '}';
    }
}
