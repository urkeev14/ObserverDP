/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.observer;

import model.subject.Subject;

/**
 *
 * @author urosv
 */
public interface Observer {
    
    public void update();
    public void setSubject(Subject subject);
    
}
