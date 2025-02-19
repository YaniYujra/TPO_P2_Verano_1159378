package org.example.model;

public class StaticQueue<T> implements Queue<T> {

    private static final int MAX = 10000;

    private final Object[] elements;
    private int count;

    public StaticQueue() {
        this.elements = new Object[MAX];
        this.count = 0;
    }

    @Override
    public int getFirst() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el primero de una cola vacia");
        }
        return (int) this.elements[0];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void add(Object element) {
        this.elements[count] = element;
        this.count++;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar de una cola vacia");
        }
        for(int i = 0; i < this.count - 1; i++) {
            this.elements[i] = this.elements[i+1];
        }
        this.count--;
    }

}
