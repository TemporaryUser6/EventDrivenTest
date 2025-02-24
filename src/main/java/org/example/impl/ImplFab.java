package org.example.impl;

import org.example.domain.EventConsumer;
import org.example.domain.EventPublisher;
import org.example.domain.EventQueue;

public class ImplFab {

    // Hide implementation from main

    private ImplFab() {} // some style checkers requires it

    public static EventQueue getEventQueue(String topicName) {
        // topicName ignored for this example task
        return new SampleEventQueue();
    }

    public static EventPublisher getEventPublisher(EventQueue eventQueue) {
        return new OrderEventPublisher(eventQueue);
    }

    public static EventConsumer getEventConsumer(String topicName) {
        // topicName ignored for this example task
        return new OrderEventConsumer();
    }
}
