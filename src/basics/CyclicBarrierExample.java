package basics;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run() {
            System.out.println("Barrier Broken");
        }
    });
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread1(cyclicBarrier));
        Thread t2 = new Thread(new MyThread1(cyclicBarrier));
        t1.start();
        t2.start();
        Thread t3 = new Thread(new MyThread1(cyclicBarrier));
        Thread t4 = new Thread(new MyThread1(cyclicBarrier));
        t3.start();
        t4.start();
    }
}

class MyThread1 implements Runnable {

    CyclicBarrier cyclicBarrier;

    public MyThread1(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Execution of " + Thread.currentThread().getName());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Started Execution of " + Thread.currentThread().getName());
    }
}