package io.ace.spring.springactivemqapp;

import io.ace.spring.springactivemqapp.config.ApplicationConfig;
import io.ace.spring.springactivemqapp.sender.MessageSender1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageSender1App {
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MessageSender1 messageSender = applicationContext.getBean(MessageSender1.class);
        messageSender.sendMessage("Hello, Kailash Shahi");
        applicationContext.close();
    }
}
