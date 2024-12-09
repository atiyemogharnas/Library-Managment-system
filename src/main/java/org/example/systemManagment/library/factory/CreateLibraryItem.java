package org.example.systemManagment.library.factory;

import org.example.systemManagment.entity.Book;
import org.example.systemManagment.entity.Magazine;
import org.example.systemManagment.entity.Refrence;
import org.example.systemManagment.entity.Thesis;
import org.example.systemManagment.library.LibraryItem;

public class CreateLibraryItem {

    public static LibraryItem createItem(String objectType) {
        if (objectType.equalsIgnoreCase("book")) {
            return new Book();
        }else if (objectType.equalsIgnoreCase("magazine")) {
            return new Magazine();
        } else if (objectType.equalsIgnoreCase("refrence")) {
            return new Refrence();
        }else if (objectType.equalsIgnoreCase("thesis")) {
            return new Thesis();
        } else {
            throw new IllegalArgumentException("Invalid library item type");
        }
    }
}
