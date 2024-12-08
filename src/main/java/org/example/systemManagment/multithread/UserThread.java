package org.example.systemManagment.multithread;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class UserThread implements Runnable {

    private final Queue<String> requestQueue;

    public UserThread(Queue<String> requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
            requestQueue.add("create_2,ghoran,arash,BOOK,1376-09-22 12:00:00,EXIST");
            requestQueue.add("land_2");
            requestQueue.add("return_2");
            requestQueue.add("update_2,BOOK,BORROWED,1376-09-22 12:00:00,null,null,null");
            requestQueue.add("delete_1");
    }
}
