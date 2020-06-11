package io.ace.spring.springactivemqapp.receiver;

import io.ace.spring.springactivemqapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class MessageReceiver2 {
    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    MessageConverter messageConverter;

    public Product receiveMessage() {
        Message message = jmsTemplate.receive();
        try {
            Product product = (Product) messageConverter.fromMessage(message);
            return product;
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }

}
