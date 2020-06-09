package io.ace.jmstest.sender;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MessageSender {

    // tcp://localhost:61616
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static String queueName = "MESSAGE_QUEUE";

    public static void main(String[] args) {
        System.out.println("URL : " + url);
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);

            MessageProducer producer = session.createProducer(destination);

            TextMessage textMessage = session.createTextMessage();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            while (true) {
                input = bufferedReader.readLine();
                if (input.equalsIgnoreCase("stop")) {
                    break;
                }
                textMessage.setText(input);
                producer.send(textMessage);
                System.out.println("Message " + textMessage.getText() + " send successfully.");
            }
            connection.close();
        } catch (JMSException e) {
            System.out.println("Connection Refused.");
        } catch (IOException ioException) {
            System.out.println("Cann't Read Datat.");
        }
    }
}
