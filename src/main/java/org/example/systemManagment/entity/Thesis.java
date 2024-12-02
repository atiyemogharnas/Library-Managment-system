package org.example.systemManagment.entity;

import org.example.systemManagment.library.LibraryItem;

public class Thesis extends LibraryItem {

    public String university;


    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public void display() {
        System.out.println("author : " + getAuthor());
        System.out.println("title : " + getTitle());
        System.out.println("university : " + getUniversity());
    }
}
