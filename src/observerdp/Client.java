/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerdp;

import interfaces.Observer;
import model.EmailTopic;
import model.EmailTopicSubscriber;

/**
 *
 * @author urosv
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmailTopic topic = new EmailTopic();

        //create observers
        Observer observer1 = new EmailTopicSubscriber("Observer 1");
        Observer observer2 = new EmailTopicSubscriber("Observer 2");
        Observer observer3 = new EmailTopicSubscriber("Observer 3");
        
        //attaching observer to subject
        observer1.setSubject(topic);
        observer2.setSubject(topic);
        observer3.setSubject(topic);
        
        //check for updates
        observer1.update();
        
        //Provider/Subject (broadcaster)
        topic.postMessage("Hello subscribers");
        
        topic.unregister(observer1);
        
        topic.postMessage("Hello againnnnnnnnnnnnnnnnnnnn");
             
        
        
    }

}
