package org.example.systemManagment.library.strategy;

import org.example.systemManagment.library.LibraryItem;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SearchByYear implements AdvancedSearchable {
    @Override
    public List<LibraryItem> performSearch(List<LibraryItem> items, String query) {
        return items.stream().filter(item -> item.getYear().compareTo((new Date(query))) == 0).collect(Collectors.toList());

    }
}
