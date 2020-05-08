/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.subject.impl;

import model.observer.Observer;
import model.subject.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author urosv
 */
public class EmailTopic implements Subject {

    private List<Observer> observers;
    private String message;

    public EmailTopic() {
        observers = new ArrayList<>();
    }

    public void postMessage(String msg) {
        waitABit();
        System.out.println("\nMessage posted to my topic : " + msg);
        this.message = msg;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> {
            observer.update();
        });
    }

    @Override
    public void register(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    //Just a method that slows down execution of a program...
    private void waitABit() {
        try {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(EmailTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
