package org.example.systemManagment.user;

import org.example.systemManagment.library.observer.Observer;


public class User extends Observer {

    private final String username;


    public User(String username) {
        this.username = username;
    }

    @Override
    public void update(String bookName) {
        System.out.println("hello " + username + " book with name "+ bookName +" is available");
    }
}
