package org.example.systemManagment.library.strategy;

import org.example.systemManagment.library.LibraryItem;

import java.util.List;

public interface AdvancedSearchable {

    List<LibraryItem> performSearch(List<LibraryItem> items, String query);
}
