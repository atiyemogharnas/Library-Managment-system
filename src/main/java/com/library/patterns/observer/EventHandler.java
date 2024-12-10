package com.library.patterns.observer;

public interface EventHandler {

     void add(Observer observer) ;
     void execute();
}
