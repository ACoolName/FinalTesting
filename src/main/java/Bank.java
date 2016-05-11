
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author teo
 */
class Bank {

    private String bankName;
    private ArrayList<Account> accounts;

    public Bank(String bankName) {
        this.bankName = bankName;
        accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean addAccount(Account account) {
        if (getAccountIndex(account.getName()) == -1) {
            return accounts.add(account);
        }
        return false;
    }

    public Account removeAccountByIndex(int index) {
        if (index < 0 || index >= accounts.size()) {
            return null;
        }
        return accounts.remove(index);
    }

    public Account removeAccountByName(String name) {
        Account a = getAccount(name);
        accounts.remove(a);
        return a;
    }

    public boolean transfer(String senderName, String receiverName, double amount) {
        if (getAccountIndex(senderName) == -1 || getAccountIndex(receiverName) == -1 || senderName.equals(receiverName) || amount <= 0) {
            return false;
        }
        Account sender = getAccount(senderName);
        Account receiver = getAccount(receiverName);
        if (sender.getBalance() < amount) {
            return false;
        }
        sender.withdraw(amount);
        receiver.deposit(amount);
        return true;
    }

    private int getAccountIndex(String name) {
        for (int i = 0; i < accounts.size(); i++) {
            Account a = accounts.get(i);
            if (a.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private Account getAccount(String name) {
        for (Account a : accounts) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        return null;
    }

}
