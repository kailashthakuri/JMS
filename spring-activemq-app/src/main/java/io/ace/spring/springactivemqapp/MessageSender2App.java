package io.ace.spring.springactivemqapp;

import io.ace.spring.springactivemqapp.config.ApplicationConfig;
import io.ace.spring.springactivemqapp.entity.Product;
import io.ace.spring.springactivemqapp.sender.MessageSender2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageSender2App {
    public static void main(String[] args) {
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MessageSender2 messageSender = applicationContext.getBean(MessageSender2.class);
        Product product = new Product();
        product.setName("Bike");
        product.setProductId(1);
        product.setQuantity(3);
        messageSender.sendMessage(product);
        applicationContext.close();
    }
}
