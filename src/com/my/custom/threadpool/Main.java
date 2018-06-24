package com.my.custom.threadpool;

public class Main {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(3,4);
        for(int i = 0; i < 5; i++) {
            Task task = new Task(i);
            threadPool.submitTask(task);
        }

    }
}
