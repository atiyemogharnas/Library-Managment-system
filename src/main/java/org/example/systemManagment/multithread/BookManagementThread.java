package org.example.systemManagment.multithread;

import org.example.systemManagment.library.LibraryService;


import java.util.concurrent.BlockingQueue;

public class BookManagementThread implements Runnable {
    private final BlockingQueue<String> requestQueue;
    private final LibraryService libraryService;

    public BookManagementThread(BlockingQueue<String> requestQueue, LibraryService libraryService) {
        this.requestQueue = requestQueue;
        this.libraryService = libraryService;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String request = requestQueue.take();
                processRequest(request);
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    private void processRequest(String request) {
        String[] req = request.split(":");
        Integer id = Integer.parseInt(req[0]);
        String reqType = req[1];

        switch (reqType) {
            case "land":
                libraryService.BorrowingBook(id);
                System.out.println("Book Borrowed!");
                break;

            case "return":
                libraryService.ReturnedBook(id, "1376-09-15 23:09:43");
                System.out.println("Book Returned!");
                break;
        }
    }
}
