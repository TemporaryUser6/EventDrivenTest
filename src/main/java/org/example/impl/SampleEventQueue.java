package org.example.impl;

import org.example.domain.EventConsumer;
import org.example.domain.EventQueue;
import org.example.domain.EventType;
import org.example.domain.OrderEvent;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

class SampleEventQueue implements EventQueue {

    List<EventConsumer> eventConsumers = new ArrayList<>();
    private final ConcurrentLinkedQueue<OrderEvent> queue = new ConcurrentLinkedQueue<>();

    Thread receiverEmulator = new Thread() {
        @Override
        public void run() {
            boolean isStop = false;
            try {
                while (!isStop) {
                    OrderEvent orderEvent = queue.poll();
                    if (orderEvent != null) {
                        if (orderEvent.getEventType() == EventType.STOP_ALL) {
                            isStop = true;
                        } else {
                            // eventConsumers access is not thread safe by design
                            for (EventConsumer eventConsumer : eventConsumers) {
                                eventConsumer.handleEvent(orderEvent);
                            }
                        }
                    } else {
                        synchronized (queue) {
                            queue.wait(500);
                        }
                    }
                }
            } catch (InterruptedException e) {
                interrupt();
            }
            System.out.println("Queue stopped @ " + LocalDateTime.now());
        }
    };

    public SampleEventQueue() {
        receiverEmulator.start();
    }

    @Override
    // eventConsumers access is not thread safe by design
    public void addConsumer(EventConsumer eventConsumer) {
        eventConsumers.add(eventConsumer);
    }

    @Override
    public void publish(OrderEvent orderEvent) {
        queue.add(orderEvent);
        synchronized (queue) {
            queue.notifyAll();
        }
    }
}
