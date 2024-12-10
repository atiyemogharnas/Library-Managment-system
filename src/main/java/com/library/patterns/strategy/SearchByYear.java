package com.library.patterns.strategy;

import com.library.model.LibraryItem;
import com.library.utils.ConvertDate;

import java.util.List;

public class SearchByYear implements AdvancedSearchStrategy {

    @Override
    public List<LibraryItem> performSearch(List<LibraryItem> items, String query) {
        return items.stream().filter(item -> item.getYear().compareTo((ConvertDate.convertStringToDate(query))) == 0).toList();
    }
}
