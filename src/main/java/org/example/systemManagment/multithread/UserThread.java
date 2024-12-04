package org.example.systemManagment.multithread;

import java.util.concurrent.BlockingQueue;

public class UserThread implements Runnable {

    private final BlockingQueue<String> requestQueue;

    public UserThread(BlockingQueue<String> requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        try {
            requestQueue.put("1:land");
            Thread.sleep(5000);
            requestQueue.put("1:return");
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
