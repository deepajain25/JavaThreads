package com.my.custom.threadpool;

public class TaskExecutor implements Runnable{
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    BlockingQueueImpl queue;

    public TaskExecutor(BlockingQueueImpl queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            Task task = queue.dequeue();
            System.out.println("Picked Thread " + Thread.currentThread().getName() + " " + task);
            task.run();
            System.out.println("Finished Thread " + Thread.currentThread().getName() + " " + task);
        }
    }
}
