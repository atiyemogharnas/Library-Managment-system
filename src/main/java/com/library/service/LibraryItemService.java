package com.library.service;

import com.library.model.LibraryItem;
import com.library.repository.DTO.LibraryItemRequestDTO;
import com.library.repository.LibraryItemRepository;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class LibraryItemService implements Searchable, Sortable {

    private static LibraryItemService instance;
    private final List<LibraryItem> libraryItems;
    private final LibraryItemRepository libraryItemRepository;

    public LibraryItemService(LibraryItemRepository libraryItemRepository) {
        this.libraryItemRepository = libraryItemRepository;
        this.libraryItems = libraryItemRepository.getLibraryItems();
    }

    public static synchronized LibraryItemService getInstance(LibraryItemRepository libraryItemRepository) {
        if (instance == null) {
            instance = new LibraryItemService(libraryItemRepository);
        }
        return instance;
    }

    @Override
    public void searchLibraryItemsByValue(String value) {
        libraryItems.stream().filter(libraryItem -> libraryItem.getTitle().toLowerCase().contains(value.toLowerCase()) ||
                libraryItem.getAuthor().toLowerCase().contains(value.toLowerCase())).forEach(libraryItem -> {
            System.out.println(libraryItem.getTitle() + " " + libraryItem.getAuthor() + " " + libraryItem.getYear());
        });
    }

    @Override
    public void sortLibraryItemsByKeyword(String sortFieldName) {
        Comparator<LibraryItem> comparator;
        if ("title".equalsIgnoreCase(sortFieldName)) {
            comparator = Comparator.comparing(LibraryItem::getTitle);
        } else if ("author".equals(sortFieldName)) {
            comparator = Comparator.comparing(LibraryItem::getAuthor);
        } else {
            comparator = Comparator.comparing(LibraryItem::getYear);
        }
        libraryItems.stream().sorted(comparator).forEach(libraryItem -> {
            System.out.println(libraryItem.getTitle() + " " + libraryItem.getAuthor() + " " + libraryItem.getYear());
        });
    }

    public void displayAllLibraryItems() {
        libraryItems.forEach(LibraryItem::display);
    }

    public void displayItem(int id) {
        LibraryItem item = libraryItemRepository.getLibraryItemById(id);
        item.display();
    }

    public void createLibraryItem(String objectType, LibraryItemRequestDTO requestDTO) {
        libraryItemRepository.addLibraryItem(objectType, requestDTO);
    }

    public void deleteLibraryItem(int id) {
        libraryItemRepository.deleteLibraryItem(id);
    }

    public void updateLibraryItem(LibraryItemRequestDTO requestDTO, Date returnDate) {
        libraryItemRepository.updateLibraryItem(requestDTO, returnDate);
    }

    public List<LibraryItem> getLibraryItems() {
        return libraryItems;
    }
}
