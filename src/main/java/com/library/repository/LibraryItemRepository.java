package com.library.repository;

import com.library.model.LibraryItem;
import com.library.patterns.builder.LibraryItemBuilder;
import com.library.patterns.factory.LibraryItemFactory;
import com.library.repository.DTO.LibraryItemRequestDTO;
import com.library.utils.FileReader;
import com.library.model.Book;
import com.library.utils.FileWriter;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

public class LibraryItemRepository {

    private final List<LibraryItem> libraryItems;

    public LibraryItemRepository() {
        try {
            this.libraryItems = FileReader.getLibraryItems();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


    public synchronized void addLibraryItem(String objectType, LibraryItemRequestDTO requestDTO) {
        libraryItems.add(LibraryItemFactory.createItem(objectType, requestDTO));
        FileWriter.writeInFile(libraryItems);
    }

    public void deleteLibraryItem(int id) {
        libraryItems.remove(getLibraryItemById(id));
        FileWriter.writeInFile(libraryItems);
    }

    public void updateLibraryItem(LibraryItemRequestDTO requestDTO, Date returnDate) {
        LibraryItem oldItem = getLibraryItemById(requestDTO.getId());
        if (requestDTO.getLibraryItemType().toUpperCase().equals(LibraryItem.LibraryItemType.BOOK.name())) {
            Book book = (Book) oldItem;
            if (book.getStatus() == Book.Status.BORROWED) {
                book.setReturnDate(returnDate);
            } else if (book.getStatus() == Book.Status.EXIST) {
                book.execute();
            }
        }
        saveUpdatedLibrary(oldItem, requestDTO);
    }

    public void saveUpdatedLibrary(LibraryItem oldItem, LibraryItemRequestDTO requestDTO) {
        LibraryItem updatedItem = new LibraryItemBuilder().from(oldItem)
                .title(requestDTO.getTitle())
                .author(requestDTO.getAuthor())
                .year(requestDTO.getYear())
                .extraInfo(requestDTO.getExtraInfo())
                .build();
        libraryItems.remove(oldItem);
        libraryItems.add(updatedItem);
        FileWriter.writeInFile(libraryItems);
    }

    public LibraryItem getLibraryItemById(int id) {
        LibraryItem item = libraryItems.stream().filter(libraryItem -> libraryItem.getId() == id).findFirst().orElse(null);
        if (item == null) {
            throw new RuntimeException("Library item not found");
        } else {
            return item;
        }
    }

    public List<LibraryItem> getLibraryItems() {
        return libraryItems;
    }
}
