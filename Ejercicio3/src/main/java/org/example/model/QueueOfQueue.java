package org.example.model;


public interface QueueOfQueue {
    Queue getFirst();
    boolean isEmpty();
    void add(Queue queue);
    Queue remove();
}
