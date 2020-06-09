package io.ace.jmstest.consumer;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageReceiver {

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static String queueName = "MESSAGE_QUEUE";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination queue = session.createQueue(queueName);

        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new TextMessageListener());
        connection.start();
    }
}
