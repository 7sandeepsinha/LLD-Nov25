package concurrency.executorCallable;

import java.util.Random;
import java.util.concurrent.Callable;

public class DeliveryChargeCalculator implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(10000);
        Random random = new Random();
        Integer charge = random.nextInt(100);
        return charge;
    }
}
