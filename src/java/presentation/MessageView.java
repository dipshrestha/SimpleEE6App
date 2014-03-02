/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation;

import boundary.MessageFacade;
import entities.Message;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author dipesh
 */
@ManagedBean(name = "MessageView")
@RequestScoped
public class MessageView {
    
    // Injects the MessageFacade session bean using the @EJB annotation
    @EJB
    private MessageFacade messageFacade;
    
    // Creates a new field
    private Message message;
    
    //private List<Message> messageList;
    
    // Calls getMessage to retrieve the message
    public Message getMessage() {
        return message;
    }
    
    // Returns the total number of messages
    public int getNumberOfMessages(){
       return messageFacade.findAll().size();
    }
    
    public List<Message> getAllMessages(){
       return this.messageFacade.findAll();
    }
    
    // Saves the message and then returns the string "theend"
    public String postMessage(){
       //this.messageFacade.create(message);
        this.messageFacade.edit(message);
       //return "theend";
       return "index";
    }
    
     // The method name starting with set... isn't shown in jsf

    public String editMessage(Message message){
        this.message.setId(message.getId());
        this.message.setMessage(message.getMessage());
        //this.messageFacade.edit(message);
       return "index";
    }
    
    public void deleteMessage(Message message) {
        this.messageFacade.remove(message);
    }
    
//       public String putMessage(Message message) {
//        this.message.setId(message.getId());
//        this.message.setMessage(message.getMessage());
//        return "index";
//    }

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
         this.message = new Message();
    }
    
}
