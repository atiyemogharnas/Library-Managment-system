package org.example.systemManagment.library;

import org.example.systemManagment.file.FileReader;
import org.example.systemManagment.entity.Book;
import org.example.systemManagment.entity.Magazine;
import org.example.systemManagment.entity.Refrence;
import org.example.systemManagment.entity.Thesis;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LibraryRepository {
    //    FileReader fileReader;
//    private  List<LibraryItem> libraryItems;
    private HashMap<Integer, LibraryItem> libraryMapping = new HashMap<>();
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public LibraryRepository(HashMap<Integer, LibraryItem> libraryMapping) {
        this.libraryMapping = libraryMapping;
    }

    public LibraryRepository() {
    }

    //        public LibraryRepository(FileReader fileReader) throws FileNotFoundException {
//        this.fileReader =fileReader;
//        this.libraryItems = fileReader.readLibrartItemesFromFile();
//    }


    public void addLibraryItem(LibraryItem item) {
        lock.lock();
        try {
            libraryMapping.put(item.getId(), item);
        } finally {
            lock.unlock();
        }
//        libraryItems.add(item);

    }

    public void deleteLibraryItem(int id) {
//        libraryItems.remove(getLibraryItemById(id));
        lock.lock();
        try {
            libraryMapping.remove(id);
        } finally {
            lock.unlock();
        }
    }

    public void updateLibraryItem(int id, LibraryItem.LibraryItemType type, String status, Date returnDate, String genre, String university, String refrenceType) {
        lock.lock();
        try {
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
        } finally {
            lock.unlock();
        }
    }

    public LibraryItem getLibraryItemById(int id) {
        LibraryItem item = libraryMapping.get(id);
        if (item == null) {
            throw new RuntimeException("Library item not found");
        } else {
            return item;
        }
    }

    public HashMap<Integer, LibraryItem> getLibraryItems() {
        return libraryMapping;
    }
}
