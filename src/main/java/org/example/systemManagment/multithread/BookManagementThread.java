package org.example.systemManagment.multithread;

import org.example.systemManagment.ConvertTime;
import org.example.systemManagment.entity.Book;
import org.example.systemManagment.library.LibraryItem;
import org.example.systemManagment.library.LibraryRepository;
import org.example.systemManagment.library.LibraryService;


import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BookManagementThread implements Runnable {
    private Queue<String> requestQueue = new LinkedList<>();
    private final LibraryService libraryService;
    private final LibraryRepository libraryRepository;
    private Lock lock = new ReentrantLock();

    public BookManagementThread(Queue<String> requestQueue, LibraryService libraryService, LibraryRepository libraryRepository) {
        this.requestQueue = requestQueue;
        this.libraryService = libraryService;
        this.libraryRepository = libraryRepository;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (!requestQueue.isEmpty()) {
                String request = requestQueue.poll();
                processRequest(request);
            }
        } finally {
            lock.unlock();
        }
    }

    private void processRequest(String request) {
        String[] req = request.split("_");
        String reqType = req[0];
        String secondPart = req[1];

        switch (reqType) {
            case "land":
                libraryService.BorrowingBook(Integer.valueOf(secondPart));
                System.out.println("Book Borrowed!");
                break;

            case "return":
                libraryService.ReturnedBook(Integer.valueOf(secondPart), "1376-09-15 23:09:43");
                System.out.println("Book Returned!");
                break;

            case "create":
                String[] split = secondPart.split(",");
                LibraryItem book = new Book(Integer.parseInt(split[0]),split[1],split[2], ConvertTime.convertStringToDate(split[4]), LibraryItem.LibraryItemType.valueOf(split[3]), Book.Status.valueOf(split[5]), null);
                libraryRepository.addLibraryItem(book);
                System.out.println("Book created!");
                break;

            case "delete":
                libraryRepository.deleteLibraryItem(Integer.parseInt(secondPart));
                System.out.println("Book Deleted!");
                break;

            case "update":
                String[] splitStr = secondPart.split(",");
                libraryRepository.updateLibraryItem(Integer.parseInt(splitStr[0]),LibraryItem.LibraryItemType.valueOf(splitStr[1]),splitStr[2],ConvertTime.convertStringToDate(splitStr[3]),splitStr[4],splitStr[5], null);
                System.out.println("Book Updated!");
                break;
        }
    }
}
