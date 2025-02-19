package org.example.model;

public interface Queue<T> {

    int getFirst();
    boolean isEmpty();
    void add(T element);
    void remove();

}
