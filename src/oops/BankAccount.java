package oops;

public class BankAccount {
    String accountNumber; // default
    public int accountBalance; // accessible anywhere
    public String accountHolderName; // accessible only inside class

    public BankAccount(){
        //default constructor
    }

    // parameterised constructor
    public BankAccount(String aNumber, int aBalance, String aHolderName){
        accountNumber = aNumber;
        accountBalance = aBalance;
        accountHolderName = aHolderName;
    }

    //copy constructor // using older object information to create new object
    public BankAccount(BankAccount account){ // deep copy always -> new object but values might be same
        accountNumber = account.accountNumber + "NEW";
        accountBalance = account.accountBalance + 1000;
        accountHolderName = account.accountHolderName;
    }


    int getAccountBalance(){
        return accountBalance;
    }

    String getAccountNumber(){
        return accountNumber;
    }

    boolean isBelowMinBalance(){
        if(getAccountBalance() < 1000) {
            return true;
        } else {
            return false;
        }
    }

    void printDetails(){
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Balance: " + getAccountBalance());
        System.out.println("Account holder Name: " + accountHolderName);
    }
}
