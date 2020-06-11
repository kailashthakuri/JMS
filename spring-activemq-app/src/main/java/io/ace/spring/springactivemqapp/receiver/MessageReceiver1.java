package io.ace.spring.springactivemqapp.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;

@Component
public class MessageReceiver1 {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    MessageConverter messageConverter;

    public String receiveMessage() {
        Message message = jmsTemplate.receive();
        try {
            String response = (String) messageConverter.fromMessage(message);
            return response;
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return null;
    }
}
