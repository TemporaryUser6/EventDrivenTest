package org.example.domain;

public interface EventPublisher {
    void publish(OrderEvent orderEvent);
}
