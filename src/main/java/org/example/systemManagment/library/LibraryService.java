package org.example.systemManagment.library;

import org.example.systemManagment.entity.Book;
import org.example.systemManagment.library.factory.CreateLibraryItem;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static org.example.systemManagment.ConvertTime.convertStringToDate;

public class LibraryService implements Searchable, Sortable {

    private static LibraryService instance;
//    private final Lock lock = new ReentrantLock();

    List<LibraryItem> libraryItems;
    LibraryRepository libraryRepository;

//    public LibraryService(LibraryRepository libraryRepository) {
//        this.libraryRepository = libraryRepository;
//        libraryItems = libraryRepository.getLibraryItems();
//        this.libraryItems = new ArrayList<>();
//    }

    private LibraryService(LibraryRepository libraryRepository){
        this.libraryRepository = libraryRepository;
        libraryItems = libraryRepository.getLibraryItems();
    }

    //first write synchronized in function
    //second double check
    public  static LibraryService getInstance(LibraryRepository libraryRepository){
        if(instance == null){
            synchronized (LibraryService.class){
                if (instance == null){
                    instance = new LibraryService(libraryRepository);
                }
            }
        }
        return instance;
    }

    @Override
    public synchronized void searchLibraryItemsByValue(String value) {
        for (LibraryItem item : libraryItems) {
            if (item.getTitle().toLowerCase().contains(value.toLowerCase()) ||
                    item.getAuthor().toLowerCase().contains(value.toLowerCase())) {
                System.out.println(item.getTitle() + " " + item.getAuthor() + " " + item.getYear());
            } else if (item.getYear().compareTo(convertStringToDate(value)) >= 0) {
                System.out.println(item.getTitle() + " " + item.getAuthor() + " " + item.getYear());
            }
        }
    }

    @Override
    public synchronized void sortByKeyword(String sortFiledName) {
        if (Objects.equals(sortFiledName.toLowerCase(), "title")) {
            libraryItems.sort(Comparator.comparing(LibraryItem::getTitle));
        } else if (Objects.equals(sortFiledName.toLowerCase(), "author")) {
            libraryItems.sort(Comparator.comparing(LibraryItem::getAuthor));
        } else {
            libraryItems.sort(Comparator.comparing(LibraryItem::getYear));
        }

        for (LibraryItem item : libraryItems) {
            System.out.println(item.getTitle() + " " + item.getAuthor() + " " + item.getYear());
        }
    }

    public synchronized void displayAllLibraryItems() {
        for (LibraryItem item : libraryItems) {
            item.display();
        }
    }

    public synchronized void displayItem(int id) {
        LibraryItem item = libraryRepository.getLibraryItemById(id);
        item.display();
    }


    public void BorrowingBook(Integer id) {
//        lock.lock();
//        try {
            Book book = (Book) libraryRepository.getLibraryItemById(id);
            if (book != null && book.getStatus() == Book.Status.EXIST) {
                libraryRepository.updateLibraryItem(book.getId(), LibraryItem.LibraryItemType.BOOK, Book.Status.BORROWED.name(), null, null, null, null);
            } else {
                throw new RuntimeException("امکان قرض گرفتن کتاب وجود ندارد");
            }
//        } finally {
//            lock.unlock();
//        }
    }

    public void ReturnedBook(Integer id, String returnDateString) {
//        lock.lock();
//        try {
            Book book = (Book) libraryRepository.getLibraryItemById(id);
            if (book != null && book.getStatus() == Book.Status.BORROWED) {
                libraryRepository.updateLibraryItem(book.getId(), LibraryItem.LibraryItemType.BOOK, Book.Status.EXIST.name(), convertStringToDate(returnDateString), null, null, null);
            } else {
                throw new RuntimeException("امکان قرض گرفته شده وجود ندارد");
            }
//        } finally {
//            lock.unlock();
//        }
    }

    public String showStatusBook(Integer id) {
        Book book = (Book) libraryRepository.getLibraryItemById(id);
        return book.getStatus().name();
    }

    public void createItem(String objectType) {
        LibraryItem item = CreateLibraryItem.createItem(objectType);
        //this is add properties from user to add item
        libraryRepository.addLibraryItem(item);
    }
}
