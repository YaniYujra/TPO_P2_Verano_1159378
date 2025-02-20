package org.example.model;

import java.util.LinkedList;

public class StaticQueueOfQueue implements QueueOfQueue{

    private static final int MAX = 100;
    private final Queue[] array;    // Arreglo de colas
    private int count;

    private static LinkedList<Queue> queues = new LinkedList<>();
    // Número de colas actualmente en la QueueOfQueue

    public StaticQueueOfQueue() {
        this.array = new Queue[MAX];
        this.count = 0;
    }

    // Verifica si la QueueOfQueue está vacía
    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }



    // Agrega una nueva cola (StaticQueue) a la QueueOfQueue
    @Override
    public void add(Queue queue) {
        if (this.count >= MAX) {
            throw new RuntimeException("No se puede agregar más colas, la capacidad está llena.");
        }
        this.array[this.count] = queue;
        this.count++;
    }

    // Elimina la primera cola de la QueueOfQueue
    @Override
    public Queue remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede eliminar, la QueueOfQueue está vacía.");
        }
        for (int i = 0; i < this.count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
        return null;
    }

    // Devuelve la primera cola (StaticQueue) de la QueueOfQueue
    @Override
    public Queue getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la primera cola de una QueueOfQueue vacía.");
        }
        return this.array[0];
    }

    // Verifica si la primera cola en la QueueOfQueue está vacía
    public boolean isFirstQueueEmpty() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede verificar la primera cola de una QueueOfQueue vacía.");
        }
        return this.array[0].isEmpty();
    }

    // Devuelve el número de colas en la QueueOfQueue
    public int size() {
        return this.count;
    }
}
