package org.example.systemManagment.multithread;

import org.example.systemManagment.ConvertTime;
import org.example.systemManagment.entity.Book;
import org.example.systemManagment.library.LibraryItem;
import org.example.systemManagment.library.LibraryRepository;
import org.example.systemManagment.library.LibraryService;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class UserThread implements Runnable {

    private final Queue<Object> requestQueue;
    private LibraryRepository libraryRepository;

    public UserThread(Queue<Object> requestQueue, LibraryRepository libraryRepository) {
        this.requestQueue = requestQueue;
        this.libraryRepository = libraryRepository;
    }

    @Override
    public void run() {
        requestQueue.add(LibraryService.getInstance(libraryRepository).BorrowingBook(0));
//        requestQueue.add("create_1,ghoran,arash,BOOK,1376-09-22 12:00:00,EXIST");
        requestQueue.add("land_0");
//        requestQueue.add("return_1");
//        requestQueue.add("update_2,BOOK,BORROWED,1376-09-22 12:00:00,null,null,null");
//        requestQueue.add("delete_1");
    }


}
