package concurrency.adderSubtractor;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        ReentrantLock mutex = new ReentrantLock();
        //ReentrantLock mutex2 = new ReentrantLock();
        // we are using same mutex for both threads, so we have only 1 key to access any critical section

        Adder adder = new Adder(count, mutex);
        Subtractor subtractor = new Subtractor(count, mutex);

        Thread t1 = new Thread(adder);
        Thread t2 = new Thread(subtractor);

        t1.start();
        t2.start();

        t1.join(); // main thread will wait here until t1 does not complete
        t2.join(); // main thread will wait here until t2 does not complete

        System.out.println(count.c);
    }
}

/*
        Running on thread t1, and want to wait for t2'completion
        from t1, call t2.join

        Running on main thread, and want to wait for t1's completion
        from main, call t1.join


        Parallel - both are reading 0 at same time
        Adder - +1, Subtractor - -1
        Seq - both will do 1 after another
        Adder goes first -> 0 -> +1 -> Subtractor -> +1 -1 -> 0
        Subtractor goes first -> 0 -> -1 Adder -> -1 +1 -> 0

 */