package concurrency.synchronised;

public class Depositor implements Runnable{

    private BankAccount account;

    public Depositor(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            account.deposit((long) i);
        }
        System.out.println("Deposit Done");
    }
}

// Can Depositor be child of BankAccount?
// Depositor is actually a task doing object -> human, app, automated flow
// Depositor is not actually a type of bank account
// Hence, Depositor cant be child of BankAccount