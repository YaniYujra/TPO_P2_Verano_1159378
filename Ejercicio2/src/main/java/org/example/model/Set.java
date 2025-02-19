package org.example.model;

public interface Set<T> {

    void add(T element);
    void remove(T element);
    boolean isEmpty();
    T choose();

}
