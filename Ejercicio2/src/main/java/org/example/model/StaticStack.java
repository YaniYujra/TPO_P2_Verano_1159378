package org.example.model;

public class StaticStack <T> implements Stack<T> {

    private static final int MAX = 10000;

    private final Object[] elements;
    private int count;

    public StaticStack() {
        this.elements = new Object[MAX];
        this.count = 0;
    }

    @Override
    public T getTop() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener el tope de una pila vacia");
        }
        return (T) this.elements[count - 1];
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public void add(T element) {
        this.elements[count] = element;
        this.count++;
    }

    @Override
    public T remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desapilar de una pila vacia");
        }
        this.count--;
        return null;
    }

}
