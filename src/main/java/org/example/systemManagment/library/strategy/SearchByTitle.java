package org.example.systemManagment.library.strategy;

import org.example.systemManagment.library.LibraryItem;

import java.util.List;

public class SearchByTitle implements AdvancedSearchable {

    @Override
    public List<LibraryItem> performSearch(List<LibraryItem> items, String query) {
        return items.stream().filter(item -> item.getTitle().toLowerCase().contains(query.toLowerCase())).toList();
    }
}
