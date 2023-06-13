package controller;

import models.Tranasction;

import java.util.UUID;

public interface TransactionList {
    public void addTransaction(Tranasction tranasction);
    public void removeTransaction(UUID uuid);
    public Tranasction[] getArray();
}
