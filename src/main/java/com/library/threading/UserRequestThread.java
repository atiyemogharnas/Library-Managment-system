package com.library.threading;

import java.util.concurrent.BlockingQueue;

public class UserRequestThread implements Runnable {

    private final BlockingQueue<Object> requestQueue;

    public UserRequestThread(BlockingQueue<Object> requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println("Adding 'land,2' to the queue...");
            requestQueue.put("land,2");
            Thread.sleep(1000);
            System.out.println("Adding 'return,2' to the queue...");
            requestQueue.put("return,2");
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}
