package org.example.systemManagment.library;

import org.example.systemManagment.FileReader;
import org.example.systemManagment.entity.Book;
import org.example.systemManagment.entity.Magazine;
import org.example.systemManagment.entity.Refrence;
import org.example.systemManagment.entity.Thesis;

import java.util.List;

public class LibraryRepository {
    FileReader fileReader;
    private final List<LibraryItem> libraryItems;


    public LibraryRepository(FileReader fileReader) {
        this.fileReader =fileReader;
        this.libraryItems = fileReader.readLibrartItemesFromFile();
    }


    public void addLibraryItem(LibraryItem item) {
        libraryItems.add(item);
    }

    public void deleteLibraryItem(int id) {
        libraryItems.remove(getLibraryItemById(id));
    }

    public void updateLibraryItem(int id, LibraryItem.LibraryItemType type, String status, Integer returnDate, String genre, String university, String refrenceType) {
        LibraryItem oldItem = getLibraryItemById(id);
        if (type == LibraryItem.LibraryItemType.BOOK) {
            Book book = (Book) oldItem;
            if (book.getStatus() == Book.Status.BORROWED) {
                book.setReturnDate(returnDate);
            }
            book.setStatus(Book.Status.valueOf(status));
            libraryItems.remove(oldItem);
            libraryItems.add(book);
        } else if (type == LibraryItem.LibraryItemType.THESIS) {
            Thesis thesis = (Thesis) oldItem;
            thesis.setUniversity(university);
            libraryItems.remove(oldItem);
            libraryItems.add(thesis);
        } else if (type == LibraryItem.LibraryItemType.MAGAZINE) {
            Magazine magazine = (Magazine) oldItem;
            magazine.setGenre(genre);
            libraryItems.remove(oldItem);
            libraryItems.add(magazine);
        } else if (type == LibraryItem.LibraryItemType.REFRENCE) {
            Refrence refrence = (Refrence) oldItem;
            refrence.setRefrenceType(Refrence.RefrenceType.valueOf(refrenceType));
            libraryItems.remove(oldItem);
            libraryItems.add(refrence);
        }
    }

    public LibraryItem getLibraryItemById(int id) {
        return libraryItems.get(id);
    }

    public List<LibraryItem> getLibraryItems() {
        return libraryItems;
    }
}
