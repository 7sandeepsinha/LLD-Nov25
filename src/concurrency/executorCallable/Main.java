package concurrency.executorCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        HelloWorldPrinter hwp = new HelloWorldPrinter();
        Thread t = new Thread(hwp);
        t.start();
        System.out.println("Hello World : " + Thread.currentThread().getName());

         */
        /*
        for (int i = 1; i <= 100; i++) {
            NumberPrinter n = new NumberPrinter(i); // task obj // 1, 2, 3
            Thread t = new Thread(n); // thread for task obj // T0, T1, T2
            t.start(); // executing
        }
        System.out.println("Loop complete :" + Thread.currentThread().getName());
         */
        /*
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 1; i <= 100; i++) {
            NumberPrinter n = new NumberPrinter(i); // task obj // 1, 2, 3
            executorService.submit(n);
        }
         */

        DeliveryChargeCalculator deliveryChargeCalculator = new DeliveryChargeCalculator();
        DiscountCalculator discountCalculator = new DiscountCalculator();
        TaxCalculator taxCalculator = new TaxCalculator();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Integer> deliveryChargeFuture = executorService.submit(deliveryChargeCalculator);
        Future<Integer> discountFuture = executorService.submit(discountCalculator);
        Future<Integer> taxFuture = executorService.submit(taxCalculator);

        System.out.println("Start billing");
        int deliveryCharge = deliveryChargeFuture.get(); // get() method is a blocking method
        int discount = discountFuture.get();
        int tax = taxFuture.get();

        int totalCost = deliveryCharge + tax - discount;
        System.out.println("Total cost: " + totalCost);

    }

}
// workQueue = Number of tasks that we want to execute, no limit on this
// workers = Number of threads in the thread pool, max limit is thread pool size


//thread number -> start from 0 when normal threads
//in executor service -> thread number starts from 1
//thread pool number starts from 1

// Ecommerce -> generate a bill
// 1. Calculate the taxes on the product
// 2. Calculate the discount on the product
// 3. Shipping charges on the product
// Tax on product price, discount on product price, shipping on product price

// Merge Sort -> tasks -> Sorting and Merging
// create multiple sorter objects, to sort different arrays and then merger object to merge
// sorter task object will be able to return values, using callable -> call() method