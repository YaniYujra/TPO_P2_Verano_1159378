package org.example.model;

public interface PriorityQueue<T> {

    int getFirst();
    int getPriority();
    boolean isEmpty();
    void add(T element, int priority);
    void remove();

}
