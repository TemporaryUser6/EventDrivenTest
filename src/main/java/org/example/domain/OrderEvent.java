package org.example.domain;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class OrderEvent {
    private static AtomicLong orderNumSequence = new AtomicLong(1);

    public OrderEvent(Order order, EventType eventType) {
      this.order = order;
      this.eventType = eventType;
      this.timestamp = LocalDateTime.now();
    }

    private final Order order;
    private final EventType eventType;
    private final LocalDateTime timestamp;

    public EventType getEventType() {
        return eventType;
    }

    public Order getOrder() {
        return order;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
