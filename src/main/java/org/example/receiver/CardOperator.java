package org.example.receiver;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import org.example.model.CreditCard;

import java.util.logging.Logger;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/PurchaseTopic")
})
public class CardOperator implements MessageListener {

    private static final Logger LOG = Logger.getLogger(CardOperator.class.getName());

    @Override
    public void onMessage(Message message) {

        try {
            CreditCard cc = message.getBody(CreditCard.class);
            LOG.info(String.format("Received cc: %s", cc ));
        }
        catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
