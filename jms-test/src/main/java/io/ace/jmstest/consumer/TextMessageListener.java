package io.ace.jmstest.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TextMessageListener implements MessageListener {
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        System.out.println("Message Received Sussfully.");
        try {
            System.out.println(textMessage.getText());
        } catch (JMSException e) {
            System.out.println("Invalid  Message Received");
        }
    }
}
