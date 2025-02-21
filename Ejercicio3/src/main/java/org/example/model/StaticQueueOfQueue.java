package org.example.model;


public class StaticQueueOfQueue implements QueueOfQueue{

    private static final int MAX = 100;
    private final Queue[] array;    // Arreglo de colas
    private int count;


    public StaticQueueOfQueue() {
        this.array = new Queue[MAX];
        this.count = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    // Agrega una nueva cola a la QueueOfQueue
    @Override
    public void add(Queue queue) {
        if (this.count >= MAX) {
            throw new RuntimeException("No se puede agregar más queues");
        }
        this.array[this.count] = queue;
        this.count++;
    }

    // Elimina la primera cola de la QueueOfQueue
    @Override
    public Queue remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede eliminar queues de una QueueOfQueue vacía");
        }
        for (int i = 0; i < this.count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.count--;
        return null;
    }

    // Devuelve la primer queue de la QueueOfQueue
    @Override
    public Queue getFirst() {
        if (this.isEmpty()) {
            throw new RuntimeException("No se puede obtener la primer Queue de una QueueOfQueue vacía.");
        }
        return this.array[0];
    }


    // Devuelve el número de colas en la QueueOfQueue
    public int size() {

        return this.count;
    }
}
