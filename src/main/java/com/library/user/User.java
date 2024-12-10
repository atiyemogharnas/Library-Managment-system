package com.library.user;

import com.library.patterns.observer.Observer;


public class User extends Observer {

    private final String username;


    public User(String username) {
        this.username = username;
    }

    @Override
    public void update() {
        System.out.println("hello " + username + " book is available");
    }
}
