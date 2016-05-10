class Account {

    private String name;
    private double balance;

    public Account(String name) {
        this.name = name;
        balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double withdraw) {
        if (balance - withdraw >= 0) {
            balance -= withdraw;
            return true;
        }
        return false;
    }

    public boolean setBalance(double amount) {
        if (amount >= 0) {
            balance = amount;
            return true;
        }
        return false;
    }
    
    public String getName() {
        return name;
    }

}