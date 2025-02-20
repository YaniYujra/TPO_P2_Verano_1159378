package org.example.util;
import org.example.model.*;

public class QueueOfQueueUtil {

    public static void concatenate(QueueOfQueue queues) {
        QueueOfQueue newQueues = new StaticQueueOfQueue();
        QueueOfQueue aux = copy(queues);

        while (!aux.isEmpty()) {
            Queue queue = aux.getFirst();
            Queue copy = copy(queue);
            newQueues.add(copy);
            aux.remove();
        }

    }

    public static Queue flat(QueueOfQueue queues) {
        Queue flatQueue = new StaticQueue();
        QueueOfQueue newQueues = copy(queues);
        while (!newQueues.isEmpty()) {
            Queue queue = newQueues.getFirst();
            while(!queue.isEmpty()) {
                flatQueue.add(queue.getFirst());
                queue.remove();
            }
            newQueues.remove();
        }
        return flatQueue;
    }


    public static void reverseWithDepth(QueueOfQueue queues) {
        if (queues.isEmpty()) {
            return;
        }
        QueueOfQueue aux = new StaticQueueOfQueue();
        aux.add(queues.getFirst());

        queues.remove();
        reverseWithDepth(queues);
        queues.add(aux.getFirst());

        while(!queues.isEmpty()) {
            Queue subQueue = copy(queues.getFirst());
            queues.remove();
            reverseQueue(subQueue);
        }
    }

    public static void reverseQueue(Queue queue) {
        if (queue.isEmpty()) {
            return;
        }
        Queue first = new StaticQueue();
        first.add(queue.getFirst());
        queue.remove();

        reverseQueue(queue);

        queue.add(first.getFirst());
    }

    public static QueueOfQueue copy(QueueOfQueue queueOfQueue) {
        QueueOfQueue newQueue = new StaticQueueOfQueue();
        QueueOfQueue aux = new StaticQueueOfQueue();

        while(!queueOfQueue.isEmpty()) {
            newQueue.add(queueOfQueue.getFirst());
            aux.add(queueOfQueue.getFirst());
            queueOfQueue.remove();
        }
        while(!aux.isEmpty()) {
            queueOfQueue.add(aux.getFirst());
            aux.remove();
        }
        return newQueue;
    }

    public static void print(QueueOfQueue queueofQueue) {
        QueueOfQueue aux = copy(queueofQueue);
        while(!aux.isEmpty()) {
            Queue queue = aux.getFirst();
            while(!queue.isEmpty()) {
                System.out.println(queue.getFirst());
                queue.remove();
            }
            aux.remove();
        }
    }

    public static Queue copy(Queue queue) {
        Queue aux = new StaticQueue();
        Queue aux2 = new StaticQueue();

        while(!queue.isEmpty()) {
            aux.add(queue.getFirst());
            aux2.add(queue.getFirst());
            queue.remove();
        }

        while(!aux2.isEmpty()) {
            queue.add(aux2.getFirst());
            aux2.remove();
        }

        return aux;
    }
}