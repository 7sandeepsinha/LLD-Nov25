package concurrency.synchronised;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Depositor depositor = new Depositor(account);
        Withdrawer withdrawer = new Withdrawer(account);

        executor.submit(depositor);
        executor.submit(withdrawer);

        executor.awaitTermination(3, TimeUnit.SECONDS);
        executor.shutdown(); // good practice to do whenever using executor framework

        System.out.println("Account balance: " + account.getBalance());
    }
}
