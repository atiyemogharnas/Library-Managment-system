package org.example.systemManagment.library;

import java.util.List;

public interface AdvancedSearchable {

    List<LibraryItem> performSearch(List<LibraryItem> items, String query);
}
