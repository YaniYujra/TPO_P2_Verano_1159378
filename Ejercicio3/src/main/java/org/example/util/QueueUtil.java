package org.example.util;

import org.example.model.Queue;
import org.example.model.StaticQueue;

public class QueueUtil {
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
    public static boolean print(Queue queue) {
        Queue copy = copy(queue);
        while(!copy.isEmpty()) {
            System.out.println(copy.getFirst());
            copy.remove();
        }
        return false;
    }

}
