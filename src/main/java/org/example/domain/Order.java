package org.example.domain;

import java.util.concurrent.atomic.AtomicLong;

public class Order {
    private static final AtomicLong orderNumSequence = new AtomicLong(1);
    private final long orderId;

    public Order() {
        this.orderId = orderNumSequence.getAndIncrement();
    }

    public long getOrderId() {
        return orderId;
    }
}
