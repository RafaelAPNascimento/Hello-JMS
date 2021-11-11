package org.example.producer;

import jakarta.ejb.Schedule;

import java.util.logging.Logger;

public class TimedProducer {

    private final Logger LOG = Logger.getLogger(TimedProducer.class.getName());

    @Schedule(hour = "*", minute = "*", second = "/3", info = "Every 3 seconds", timezone = "UTC", persistent = false)
    public void sendToQueue() {

        LOG.info("producing...");
    }
}
