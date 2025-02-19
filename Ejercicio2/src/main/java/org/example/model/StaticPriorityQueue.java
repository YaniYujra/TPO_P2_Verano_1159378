package org.example.model;

public class StaticPriorityQueue<T> implements PriorityQueue<T> {

    private static final int MAX = 10000;

    private final Object[] elements;
    private final int[] priorities;
    private int count;

    public StaticPriorityQueue() {
        this.elements = new Object[MAX];
        this.priorities = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getFirst() {
        if(this.isEmpty()) {
           throw new RuntimeException("No se puede obtener el valor de una cola vacía");
        }
        return (int) this.elements[0];
    }

    @Override
    public int getPriority() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la prioridad de una cola vacía");
        }
        return this.priorities[0];
    }

    @Override
    public boolean isEmpty() {

        return this.count == 0;
    }

    @Override
    public void add(T element, int priority) {
        if(this.count == MAX) { // TODO Esto debería estar en todas las estructuras
            throw new RuntimeException("No se tiene capacidad para almacenar un nuevo elemento");
        }
        if (this.isEmpty()) {
            this.elements[0] = element;
            this.priorities[0] = priority;
            this.count = 1;
            return;
        }

        if (this.priorities[this.count - 1] <= priority) {
            this.elements[count] = element;
            this.priorities[count] = priority;
            this.count++;
            return;
        }

        if (this.priorities[0] > priority) {
            for (int i = this.count - 1; i > 0; i--) {
                this.elements[i + 1] = this.elements[i];
                this.priorities[i + 1] = this.priorities[i];
            }
            this.elements[0] = element;
            this.priorities[0] = priority;
            this.count++;
            return;
        }

        int index = findIndex(priority);

        if(index != -1) {
            int candidate = index;
            while(this.priorities[candidate] == priority) {
                candidate++;
            }
            for (int i = this.count - 1; i >= candidate ; i--) {
                this.elements[i + 1] = this.elements[i];
                this.priorities[i + 1] = this.priorities[i];
            }
            this.elements[candidate] = element;
            this.priorities[candidate] = priority;
            this.count++;
            return;
        }

        int candidate = 0;
        while(this.priorities[candidate] <= priority) {
            candidate++;
        }

        for (int i = this.count - 1; i >= candidate ; i--) {
            this.elements[i + 1] = this.elements[i];
            this.priorities[i + 1] = this.priorities[i];
        }
        this.elements[candidate] = element;
        this.priorities[candidate] = priority;
    }

    private int findIndex(int priority) {
        for(int i = 0; i < this.count; i++) {
            if(this.priorities[i] == priority) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void remove() {
        if(this.isEmpty()) {
            throw new RuntimeException("No se puede desacolar una cola vacía");
        }

        for(int i = 0; i < this.count - 1; i++) {
            this.elements[i] = this.elements[i + 1];
            this.priorities[i] = this.priorities[i + 1];
        }

        this.count--;
    }
}
