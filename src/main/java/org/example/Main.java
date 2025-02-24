package org.example;

import org.example.domain.*;
import org.example.impl.ImplFab;

import java.time.LocalDateTime;

public class Main {

    private static final String ORDERS_TOPIC_NAME = "ORDERS_TOPIC";
    public static void main(String[] args) {

        System.out.println("Task started @ " + LocalDateTime.now());

        // 1000 styles of code could be here - ask reviewers before ...
        EventQueue eventQueue = ImplFab.getEventQueue(ORDERS_TOPIC_NAME);
        EventPublisher eventPublisher = ImplFab.getEventPublisher(eventQueue);
        eventQueue.addConsumer(ImplFab.getEventConsumer(ORDERS_TOPIC_NAME));

        //create several OrderEvent instances with different types (ORDER_PLACED, ORDER_CONFIRMED),
        // and use the OrderEventPublisher to publish these events.

        Order testOrder1 = new Order();
        OrderEvent orderEvent = new OrderEvent(testOrder1, EventType.ORDER_CONFIRMED);
        eventPublisher.publish(orderEvent);

        orderEvent = new OrderEvent(testOrder1, EventType.ORDER_PLACED);
        eventPublisher.publish(orderEvent);

        Order testOrder2 = new Order();
        orderEvent = new OrderEvent(testOrder2, EventType.ORDER_CONFIRMED);
        eventPublisher.publish(orderEvent);

        orderEvent = new OrderEvent(testOrder2, EventType.ORDER_PLACED);
        eventPublisher.publish(orderEvent);

        orderEvent = new OrderEvent(null, EventType.STOP_ALL);
        eventPublisher.publish(orderEvent);

        System.out.println("Send events completed @ " + LocalDateTime.now());
    }
}