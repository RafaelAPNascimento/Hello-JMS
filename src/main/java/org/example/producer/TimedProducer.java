package org.example.producer;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Schedule;
import jakarta.ejb.Stateless;

import java.util.logging.Logger;

@Stateless
public class TimedProducer {

    private final Logger LOG = Logger.getLogger(TimedProducer.class.getName());

    @Schedule(hour = "*", minute = "*", second = "*/3", info = "Every 3 seconds", timezone = "UTC", persistent = false)
    public void sendToQueue() {

        LOG.info("producing...");
    }
}
