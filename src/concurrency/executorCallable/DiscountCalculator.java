package concurrency.executorCallable;

import java.util.Random;
import java.util.concurrent.Callable;

public class DiscountCalculator implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Random random = new Random();
        Integer charge = random.nextInt(100);
        return charge;
    }
}
