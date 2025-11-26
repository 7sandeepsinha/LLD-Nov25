package concurrency.synchronised;

public class BankAccount {
    private Long balance = 0L;

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public synchronized void deposit(Long amount){
        if(amount > 0){
           // synchronized (this) {
                this.balance += amount;
           // }
        }
    }

    public synchronized void withdrawWithMethodSync(Long amount){
        if(amount > 0 && this.balance >= amount){
           // synchronized (this) {
                this.balance -= amount;
           // }
        }
    }

    public void withdrawWithBlockSync(Long amount){
        if(amount > 0 && this.balance >= amount){
            synchronized (this) {
            this.balance -= amount;
            }
        }
    }
}
// We have options to either make the entire method thread safe -> synchronised method
// or, we can find the exact code and make that much area thread safe -> synchronised block