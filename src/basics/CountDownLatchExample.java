package basics;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread(countDownLatch));
        Thread t2 = new Thread(new MyThread(countDownLatch));
        t1.start();
        t2.start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main Finishing.....!!!!!!!!!!!");
    }
}

class MyThread implements Runnable {

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
    CountDownLatch countDownLatch;

    public MyThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Execution of " + Thread.currentThread().getName());
        countDownLatch.countDown();
    }
}
