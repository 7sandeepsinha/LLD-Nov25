package concurrency.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Shirt> store;
    private int maxSize;
    private String name;
    private Semaphore semaProducer;
    private Semaphore semaConsumer;

    public Producer(Queue<Shirt> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    public Producer(Queue<Shirt> store, int maxSize, String name, Semaphore semaProducer, Semaphore semaConsumer) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.semaProducer = semaProducer;
        this.semaConsumer = semaConsumer;
    }

    @Override
    public void run(){
        while(true){
            System.out.println("Shirt added by producer : " + name);
//            if(store.size() < maxSize){
//                store.add(new Shirt());
//            }
            try {
                semaProducer.acquire(); // number of keys for producer decreases
                store.add(new Shirt());
                semaConsumer.release(); // number of keys for consumer increases
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Store size: " + store.size());
        }
    }
}
