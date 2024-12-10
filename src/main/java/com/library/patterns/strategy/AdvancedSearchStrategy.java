package com.library.patterns.strategy;

import com.library.model.LibraryItem;

import java.util.List;

public interface AdvancedSearchStrategy {

    List<LibraryItem> performSearch(List<LibraryItem> items, String query);
}
