package com.library.model;

public class Reference extends LibraryItem {

    public ReferenceType referenceType;

    public enum ReferenceType {
        Dictionary,
        Encyclopedia
    }

    public ReferenceType getReferenceType() {
        return referenceType;
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
                ", ReferenceType='" + getReferenceType() + '\'' +
                '}';
    }
}
