package basics;

public class OddEvenPrintThreads {
    public static void main(String[] args) {
        final Data myData = new Data(1);
        Thread t1 = new Thread(new OddThread(myData));
        Thread t2 = new Thread(new EvenThread(myData));
        t1.start();
        t2.start();
    }
}

class OddThread implements Runnable {
    private Data data;

    OddThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        synchronized (data) {
            while (data.num < 10) {
                while (data.num % 2 == 0) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + data);
                data.notifyAll();
                data.num++;
            }
        }

    }
}

class EvenThread implements Runnable {
    private final Data data;

    EvenThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        synchronized (data) {
            while (data.num < 10) {
                if (data.num % 2 != 0) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " " + data);
                data.notifyAll();
                data.num++;
            }
        }
    }
}

class Data {
    int num;

    public Data(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Data{" +
                "num=" + num +
                '}';
    }
}