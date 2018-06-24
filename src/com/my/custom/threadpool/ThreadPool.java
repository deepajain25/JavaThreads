package com.my.custom.threadpool;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

class ThreadPool {

    private BlockingQueueImpl queue;
    private Thread threads[];

    ThreadPool(int queueSize, int numThreads) {
        queue = new BlockingQueueImpl(queueSize);
        threads = new Thread[numThreads];
        TaskExecutor taskExecutor = new TaskExecutor(queue);
        for(int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(taskExecutor);
            thread.start();
        }
    }


    void submitTask(Task task) {
        queue.enqueue(task);
    }
}
