package org.example.model;

import java.util.Random;

public class StaticSet<T> implements Set<T> {

    private static final int MAX = 10000;

    private final Object[] elements;
    private int count;
    private final Random random;

    public StaticSet() {
        this.elements = new Object[MAX];
        this.count = 0;
        this.random = new Random();
    }

    @Override
    public void add(T element) {
        for(int i = 0; i < count; i++) {
            if(elements[i] == element) {
                return;
            }
        }
        elements[count] = element;
        count++;
    }

    @Override
    public void remove(T element) {
        for(int i = 0; i < count; i++) {
            if(elements[i] == element) {
                elements[i] = elements[count - 1];
                count--;
                return;
            }
        }
    }

    @Override
    public boolean isEmpty() {

        return this.count == 0;
    }

    @Override
    public T choose() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede elegir un elemento de un conjunto vacío");
        }
        if(this.count == 1) {
            return (T) elements[0];
        }
        int randomIndex = random.nextInt(count);
        return (T) elements[randomIndex];
    }
}
