package org.example.producer;

import jakarta.annotation.Resource;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Schedule;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSProducer;
import jakarta.jms.Queue;
import jakarta.jms.TextMessage;

@Stateless
@LocalBean
public class TimedProducer {

    @Inject
    private JMSContext jmsContext;

    @Resource(lookup = "jms/HelloQueue")
    private Queue queue;

    @Schedule(hour = "*", minute = "*", second = "*/3", info = "Every 3 seconds", timezone = "UTC", persistent = false)
    public void sendToQueue() {

        TextMessage textMessage = jmsContext.createTextMessage("New Text Message");
        JMSProducer producer = jmsContext.createProducer();

        producer.send(queue, textMessage);
    }
}
