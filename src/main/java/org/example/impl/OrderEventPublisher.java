package org.example.impl;

import org.example.domain.EventPublisher;
import org.example.domain.EventQueue;
import org.example.domain.OrderEvent;

class OrderEventPublisher implements EventPublisher {

    private final EventQueue eventQueue;

    public OrderEventPublisher(EventQueue eventQueue) {
        this.eventQueue = eventQueue;
    }

    @Override
    public void publish(OrderEvent orderEvent) {

        eventQueue.publish(orderEvent);
    }
}
