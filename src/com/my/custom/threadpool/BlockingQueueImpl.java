package com.my.custom.threadpool;


import java.util.concurrent.LinkedBlockingQueue;

class BlockingQueueImpl {
    private static int maxSize;
    private LinkedBlockingQueue<Task> queue;

    BlockingQueueImpl(int size) {
        maxSize = size;
        queue = new LinkedBlockingQueue<>(size);
    }

    synchronized void enqueue(Task task) {
        while(queue.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(queue.size() == 0) {
            notifyAll();
        }
        queue.offer(task);

    }

    synchronized Task dequeue() {
        while(queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(queue.size() == maxSize) {
            notifyAll();
        }
        return queue.poll();
    }
}
