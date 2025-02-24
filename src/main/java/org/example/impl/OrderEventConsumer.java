package org.example.impl;

import org.example.domain.EventConsumer;
import org.example.domain.OrderEvent;

class OrderEventConsumer implements EventConsumer {

    private static final String CONFIRMED = "Order [%s] confirmed, timestamp: %s\n";
    private static final String PLACED = "Order [%s] placed, timestamp: %s\n";


    @Override
    public void handleEvent(OrderEvent orderEvent) {
        switch (orderEvent.getEventType()) {
            case ORDER_CONFIRMED:
                System.out.printf(CONFIRMED, orderEvent.getOrder().getOrderId(), orderEvent.getTimestamp());
                break;
            case ORDER_PLACED:
                System.out.printf(PLACED, orderEvent.getOrder().getOrderId(), orderEvent.getTimestamp());
                break;
        }
    }
}
