package org.example.systemManagment.library;

import org.example.systemManagment.file.FileReader;
import org.example.systemManagment.entity.Book;
import org.example.systemManagment.entity.Magazine;
import org.example.systemManagment.entity.Refrence;
import org.example.systemManagment.entity.Thesis;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class LibraryRepository {
    FileReader fileReader;
//    private  List<LibraryItem> libraryItems;
    private  ConcurrentHashMap<Integer, LibraryItem> libraryMapping = new ConcurrentHashMap<>();

    public LibraryRepository(ConcurrentHashMap<Integer, LibraryItem> libraryMapping) {
        this.libraryMapping = libraryMapping;
    }

    public LibraryRepository() {
    }

    //        public LibraryRepository(FileReader fileReader) throws FileNotFoundException {
//        this.fileReader =fileReader;
//        this.libraryItems = fileReader.readLibrartItemesFromFile();
//    }


    public void addLibraryItem(LibraryItem item) {
//        libraryItems.add(item);
        libraryMapping.put(item.getId(), item);
    }

    public void deleteLibraryItem(int id) {
//        libraryItems.remove(getLibraryItemById(id));
        libraryMapping.remove(id);
    }

    public void updateLibraryItem(int id, LibraryItem.LibraryItemType type, String status, Date returnDate, String genre, String university, String refrenceType) {
        LibraryItem oldItem = getLibraryItemById(id);
        if (type == LibraryItem.LibraryItemType.BOOK) {
            Book book = (Book) oldItem;
            if (book.getStatus() == Book.Status.BORROWED) {
                book.setReturnDate(returnDate);
            }
            book.setStatus(Book.Status.valueOf(status));
//            libraryItems.remove(oldItem);
//            libraryItems.add(book);
            libraryMapping.put(id, book);
        } else if (type == LibraryItem.LibraryItemType.THESIS) {
            Thesis thesis = (Thesis) oldItem;
            thesis.setUniversity(university);
            libraryMapping.put(id, thesis);
//            libraryItems.remove(oldItem);
//            libraryItems.add(thesis);
        } else if (type == LibraryItem.LibraryItemType.MAGAZINE) {
            Magazine magazine = (Magazine) oldItem;
            magazine.setGenre(genre);
//            libraryItems.remove(oldItem);
//            libraryItems.add(magazine);
            libraryMapping.put(id, magazine);
        } else if (type == LibraryItem.LibraryItemType.REFRENCE) {
            Refrence refrence = (Refrence) oldItem;
            refrence.setRefrenceType(Refrence.RefrenceType.valueOf(refrenceType));
//            libraryItems.remove(oldItem);
//            libraryItems.add(refrence);
            libraryMapping.put(id, refrence);
        } else {
            throw new RuntimeException("Unknown library item type");
        }
    }

    public LibraryItem getLibraryItemById(int id) {
        LibraryItem item = libraryMapping.get(id);
        if (item == null) {
            throw new RuntimeException("Library item not found");
        }else {
            return item;
        }
    }

    public ConcurrentHashMap<Integer, LibraryItem> getLibraryItems() {
        return libraryMapping;
    }
}
