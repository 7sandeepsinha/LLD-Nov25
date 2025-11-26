package concurrency.semaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Queue<Shirt> store;
    private int maxSize;
    private String name;
    private Semaphore semaProducer;
    private Semaphore semaConsumer;

    public Consumer(Queue<Shirt> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    public Consumer(Queue<Shirt> store, int maxSize, String name, Semaphore semaProducer, Semaphore semaConsumer) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.semaProducer = semaProducer;
        this.semaConsumer = semaConsumer;
    }

    @Override
    public void run() {
        while(true){
            System.out.println("Shirt bought by consumer : " + name);
//            if(store.size() > 0){ // C1 came here -> 1
//                store.remove(); // C2 was removing the item , // When C1 reaches, store is empty
//            }
            try {
                semaConsumer.acquire(); // number of keys for consumer decreases
                store.remove();
                semaProducer.release(); // // number of keys for producer increases
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Store size: " + store.size());
        }
    }
}
