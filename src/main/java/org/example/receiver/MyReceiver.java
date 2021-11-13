package org.example.receiver;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

import java.util.logging.Logger;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/HelloQueue")
})
public class MyReceiver implements MessageListener {

    private final static Logger LOG = Logger.getLogger(MyReceiver.class.getName());

    @Override
    public void onMessage(Message message) {

        TextMessage textMessage = (TextMessage) message;
        try {
            LOG.info(">>> received: " + textMessage.getText());
        }
        catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
