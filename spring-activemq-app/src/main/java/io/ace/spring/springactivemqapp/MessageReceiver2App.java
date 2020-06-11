package io.ace.spring.springactivemqapp;

import io.ace.spring.springactivemqapp.config.ApplicationConfig;
import io.ace.spring.springactivemqapp.entity.Product;
import io.ace.spring.springactivemqapp.receiver.MessageReceiver2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageReceiver2App {
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MessageReceiver2 messageReceiver2 = applicationContext.getBean(MessageReceiver2.class);
        Product product = messageReceiver2.receiveMessage();
        System.out.println(product);
        applicationContext.close();
    }
}
