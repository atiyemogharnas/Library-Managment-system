package org.example.systemManagment.entity;

import org.example.systemManagment.library.LibraryItem;

public class Refrence extends LibraryItem {

    public RefrenceType refrenceType;

    public enum RefrenceType {
        Dictionary,
        Encyclopedia
    }

    public RefrenceType getRefrenceType() {
        return refrenceType;
    }

    public void setRefrenceType(RefrenceType refrenceType) {
        this.refrenceType = refrenceType;
    }

    @Override
    public void display() {
        System.out.println("author : " + getAuthor());
        System.out.println("title : " + getTitle());
        System.out.println("Type: " + getType());
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "title='" + getTitle() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", year='" + getYear() + '\'' +
                ", refrenceType='" + getRefrenceType() + '\'' +
                '}';
    }

}
