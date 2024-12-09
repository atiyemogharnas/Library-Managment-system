package org.example.systemManagment.entity;

import org.example.systemManagment.library.LibraryItem;

public class Magazine extends LibraryItem {

    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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
