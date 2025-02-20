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
        Queue queue = new StaticQueue();
        Queue queue2 = new StaticQueue();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue2.add(4);
        queue2.add(5);
        queue2.add(6);

        System.out.println("Primera Queue: ");
        QueueUtil.print(queue);
        System.out.println("Segunda Queue: ");
        QueueUtil.print(queue2);

        queueOfQueue.add(queue);
        queueOfQueue.add(queue2);
        System.out.println("Queue of Queues: ");
        QueueOfQueueUtil.print(queueOfQueue);

    //    QueueOfQueueUtil.flat(queueOfQueue);
    //    QueueOfQueueUtil.concatenate(queueOfQueue);
    //    QueueOfQueueUtil.reverseWithDepth(queueOfQueue);

    }
}