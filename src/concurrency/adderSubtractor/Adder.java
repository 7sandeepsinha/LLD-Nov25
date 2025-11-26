package concurrency.adderSubtractor;

import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Runnable {

    private Count count;
    private ReentrantLock mutex;

    public Adder(Count count, ReentrantLock mutex) {
        this.count = count;
        this.mutex = mutex;
    }

    @Override
    public void run() {
        System.out.println("Hello Adder");
        for(int i = 1; i <= 10000000; i++) {
            mutex.lock();
            count.c = count.c + 1;
            mutex.unlock();
        }
    }
}
// HW -> replace the mutex with semaphore of size 1