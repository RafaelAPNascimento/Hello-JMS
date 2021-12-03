package org.example.producer;

import jakarta.annotation.Resource;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSProducer;
import jakarta.jms.Topic;
import org.example.model.CreditCard;

@Stateless
@LocalBean
public class TopicProducerService {

    @Inject
    private JMSContext context;

    @Resource(lookup = "jms/PurchaseTopic")
    private Topic helloTopic;

    public void sendMessage(CreditCard creditCard) {

        JMSProducer producer = context.createProducer();
        producer.send(helloTopic, creditCard);
    }
}
