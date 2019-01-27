package Code;

public class Account {
    private static Account instance;
    private long balance;

    public static Account getInstance() {
        if (instance == null) {
            instance = new Account();
        }

        return instance;
    }

    private Account(){
        balance = 0;
    }

    public synchronized void accountOperations(long operation) {
        balance += operation;
    }

    public long getBalance() {
        return balance;
    }
}

