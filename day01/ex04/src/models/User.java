package models;

import controller.TransactionList;
import controller.TransactionLinkedList;
import controller.UserIdsGenerator;

import java.util.UUID;

public class User {
    int Idetifier;
    String Name;
    int Balance;

    private TransactionList transactionList;

    public User(String name, int balance) {
        Name = name;
        Balance = balance;
        if (Balance < 0) {
            Balance = 0;
        }
        this.transactionList = new TransactionLinkedList();
        this.Idetifier = UserIdsGenerator.instance.generateId();
    }

    public int getIdetifier() {
        return Idetifier;
    }

    public String getName() {
        return Name;
    }

    public int getBalance() {
        return Balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "Idetifier=" + Idetifier +
                ", Name='" + Name + '\'' +
                ", Balance=" + Balance +
                '}';
    }

    public Tranasction[] getTransactions() {
        return transactionList.getArray();
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public void addTransaction(Tranasction tranasction) {
        transactionList.addTransaction(tranasction);
    }

    public void removeTransaction(UUID transactionId) {
        transactionList.removeTransaction(transactionId);
    }
}
