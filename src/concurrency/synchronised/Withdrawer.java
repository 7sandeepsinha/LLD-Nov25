package concurrency.synchronised;

public class Withdrawer implements Runnable{

    private BankAccount account;

    public Withdrawer(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            account.withdrawWithBlockSync((long) i);
        }
        System.out.println("Withdraw completed");
    }
}
