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
            requestQueue.put("create_2,ghoran,arash,BOOK,1376-09-22 12:00:00,EXIST");
            Thread.sleep(5000);
            requestQueue.put("land_2");
            Thread.sleep(5000);
            requestQueue.put("return_2");
            Thread.sleep(5000);
            requestQueue.put("update_2,BOOK,BORROWED,1376-09-22 12:00:00,null,null,null");
            Thread.sleep(5000);
            requestQueue.put("delete_1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
