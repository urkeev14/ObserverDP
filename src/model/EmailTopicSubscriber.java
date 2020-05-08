/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Observer;
import interfaces.Subject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author urosv
 */
public class EmailTopicSubscriber implements Observer{

    private String name;
    
    //Reference to our Subject class
    private Subject topic;

    public EmailTopicSubscriber(String name) {
        this.name = name;
    }
    
    
    
    @Override
    public void update() {
        waitABit();
        String message = (String) topic.getUpdate(this);
        if(message == null)
            System.out.println(name + "[No new message on this topic]\n");
        else
            System.out.println(name + "-> [Retrieving message : " + message + "]");
    }

    @Override
    public void setSubject(Subject subject) {
        this.topic = subject;
        subject.register(this);
    }

    //Just a method that slows down execution of a program...
    private void waitABit() {
        try {
            Thread.currentThread().sleep(1500);
        } catch (InterruptedException ex) {
            Logger.getLogger(EmailTopicSubscriber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
