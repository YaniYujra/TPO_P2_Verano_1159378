package org.example.model;

public interface Stack<T> {

    T getTop();
    boolean isEmpty();
    void add(T element);
    T remove();

}
