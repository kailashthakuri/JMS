package io.ace.spring.springactivemqapp.sender;

import io.ace.spring.springactivemqapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class MessageSender2 {

    @Autowired
    JmsTemplate jmsTemplate;


    public void sendMessage(Product product) {
        this.jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(product);
            }
        });
    }
}
