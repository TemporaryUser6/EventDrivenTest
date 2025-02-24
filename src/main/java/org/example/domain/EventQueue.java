package org.example.domain;

public interface EventQueue {
    void addConsumer(EventConsumer eventConsumer);

    void publish(OrderEvent orderEvent);
}
