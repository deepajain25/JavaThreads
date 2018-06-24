package com.my.custom.threadpool;

public class Task implements Runnable {
    int taskNumber;
    public Task(int taskNumber) {
        this.taskNumber = taskNumber;
    }

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

    @Override
    public void run() {
        System.out.println("Start Execution of Task " + taskNumber);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End Execution of Task " + taskNumber);
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskNumber=" + taskNumber +
                '}';
    }
}
