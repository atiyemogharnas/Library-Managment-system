package com.library.threading;

import com.library.service.BookService;

import java.util.concurrent.BlockingQueue;

public class ProcessUserRequestThread implements Runnable {

    private final BlockingQueue<Object> blockingQueue;
    private final BookService bookService;

    public ProcessUserRequestThread(BlockingQueue<Object> queue, BookService bookService) {
        this.bookService = bookService;
        this.blockingQueue = queue;
    }

    @Override
    public void run() {
        while (!blockingQueue.isEmpty()) {
            try {
                Object request = blockingQueue.take();
                processRequest(request instanceof String ? (String) request : "");
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    private void processRequest(String request) {
        String[] req = request.split(",");
        String reqType = req[0];
        String secondPart = req[1];

        switch (reqType) {
            case "land":
                bookService.BorrowingBook(Integer.valueOf(secondPart));
                System.out.println("Book Borrowed!");
                break;

            case "return":
                bookService.ReturnedBook(Integer.valueOf(secondPart));
                System.out.println("Book Returned!");
                break;
        }
    }
}
