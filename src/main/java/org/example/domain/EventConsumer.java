package org.example.domain;

public interface EventConsumer {
    void handleEvent(OrderEvent orderEvent);
}
