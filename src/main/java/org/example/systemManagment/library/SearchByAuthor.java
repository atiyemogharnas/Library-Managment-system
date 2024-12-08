package org.example.systemManagment.library;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByAuthor implements AdvancedSearchable{
    @Override
    public List<LibraryItem> performSearch(List<LibraryItem> items, String query) {
        return items.stream().filter(item -> item.getAuthor().toLowerCase().contains(query.toLowerCase())).collect(Collectors.toList());
    }
}
