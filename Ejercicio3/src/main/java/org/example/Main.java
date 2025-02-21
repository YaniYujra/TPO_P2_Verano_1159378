package org.example;

import org.example.model.Queue;
import org.example.model.QueueOfQueue;
import org.example.model.StaticQueue;
import org.example.model.StaticQueueOfQueue;
import org.example.util.QueueOfQueueUtil;
import org.example.util.QueueUtil;

public class Main {
    public static void main(String[] args) {
        QueueOfQueue queueOfQueue = new StaticQueueOfQueue();
        QueueOfQueue queueOfQueue2 = new StaticQueueOfQueue();

        Queue queue = new StaticQueue();
        Queue queue2 = new StaticQueue();

        Queue queue3 = new StaticQueue();
        Queue queue4 = new StaticQueue();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue2.add(4);
        queue2.add(5);
        queue2.add(6);

        queue3.add(10);
        queue3.add(11);
        queue3.add(12);

        queue4.add(13);
        queue4.add(14);
        queue4.add(15);

        System.out.println("Primera Queue: ");
        QueueUtil.print(queue);
        System.out.println("Segunda Queue: ");
        QueueUtil.print(queue2);

        queueOfQueue.add(queue);
        queueOfQueue.add(queue2);
//        System.out.println("Primera Queue of Queues: ");
//        QueueOfQueueUtil.print(queueOfQueue);

        System.out.println("Tercera Queue: ");
        QueueUtil.print(queue3);
        System.out.println("Cuarta Queue: ");
        QueueUtil.print(queue4);

        queueOfQueue2.add(queue3);
        queueOfQueue2.add(queue4);
//        System.out.println("Segunda Queue of Queues: ");
//        QueueOfQueueUtil.print(queueOfQueue2);

//        Queue flatQ = QueueOfQueueUtil.flat(queueOfQueue);
//        System.out.println("flat: ");
//        QueueUtil.print(flatQ);

//        QueueOfQueue concatQ = QueueOfQueueUtil.concatenate(queueOfQueue, queueOfQueue2);
//        System.out.println("concatenación: ");
//        QueueOfQueueUtil.print(concatQ);

    }
}