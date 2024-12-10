package com.library.controller;

import com.library.patterns.strategy.SearchByTitle;
import com.library.patterns.strategy.SearchByYear;
import com.library.repository.DTO.LibraryItemRequestDTO;
import com.library.service.BookService;
import com.library.service.LibraryItemService;
import com.library.threading.ProcessUserRequestThread;
import com.library.threading.UserRequestThread;
import com.library.utils.SerializeFile;

import java.util.Date;
import java.util.concurrent.*;

public class LibraryItemController {

    private final LibraryItemService libraryItemService;
    private final BookService bookService;
    private final SearchByTitle searchByTitle = new SearchByTitle();
    private final SearchByYear searchByYear = new SearchByYear();
    private  BlockingQueue<Object> queue = new LinkedBlockingQueue<>();

    public LibraryItemController(LibraryItemService libraryItemService, BookService bookService) {
        this.libraryItemService = libraryItemService;
        this.bookService = bookService;
    }

    public void createLibraryItem(String objectType, LibraryItemRequestDTO requestDTO) {
        libraryItemService.createLibraryItem(objectType, requestDTO);
        System.out.println("create item successful");
    }

    public void updateLibraryItem(LibraryItemRequestDTO requestDTO, Date returnDate) {
        libraryItemService.updateLibraryItem(requestDTO, returnDate);
        System.out.println("update item successful");
    }

    public void deleteLibraryItem(int id) {
        libraryItemService.deleteLibraryItem(id);
        System.out.println("delete item successful");
    }

    public void displayLibraryItem(int id) {
        libraryItemService.displayItem(id);
    }

    public void displayAllLibraryItems() {
        libraryItemService.displayAllLibraryItems();
    }

    public void searchLibraryItemsByValue(String value) {
        libraryItemService.searchLibraryItemsByValue(value);
    }

    public void sortLibraryItems(String sortFieldName) {
        libraryItemService.sortLibraryItemsByKeyword(sortFieldName);
    }

    public void borrowingBook(int id) {
        bookService.BorrowingBook(id);
        System.out.println("borrowing book successful");
    }

    public void returningBook(int id) {
        bookService.ReturnedBook(id);
        System.out.println("returning book successful");
    }

    public void showStatusBook(int id) {
        System.out.println(bookService.showStatusBook(id));
    }

    public void searchByTitle(String title) {
        searchByTitle.performSearch(libraryItemService.getLibraryItems(), title).forEach(libraryItem -> {
            System.out.println(libraryItem.getTitle() + " " + libraryItem.getAuthor() + " " + libraryItem.getYear());
        });
    }

    public void searchByYear(String year) {
        searchByYear.performSearch(libraryItemService.getLibraryItems(), year).forEach(libraryItem -> {
            System.out.println(libraryItem.getTitle() + " " + libraryItem.getAuthor() + " " + libraryItem.getYear());
        });
    }

    public void serializeAndDeserializeLibraryItems() {
        SerializeFile.serializeWithProtoc();
    }

    public void multithreaded() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable userRequestTask = new UserRequestThread(queue);
        Runnable processUserRequestTask = new ProcessUserRequestThread(queue, bookService);

        executorService.submit(userRequestTask);
        executorService.submit(processUserRequestTask);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.err.println("Forcing shutdown...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted while waiting for executor to terminate: " + e.getMessage());
        }

        System.out.println("Execution completed.");
    }
}
