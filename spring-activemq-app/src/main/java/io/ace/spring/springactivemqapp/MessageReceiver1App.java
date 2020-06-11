package io.ace.spring.springactivemqapp;

import io.ace.spring.springactivemqapp.config.ApplicationConfig;
import io.ace.spring.springactivemqapp.receiver.MessageReceiver1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageReceiver1App {
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MessageReceiver1 messageReceiver1 = applicationContext.getBean(MessageReceiver1.class);
        String s = messageReceiver1.receiveMessage();
        System.out.println(s);
        applicationContext.close();
    }
}
