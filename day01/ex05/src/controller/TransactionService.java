package controller;

import models.Tranasction;
import models.User;

import java.util.UUID;

public class TransactionService {
    public TransactionService() {
        this.users = new UserArrayList();
    }

    UserList users;

    public void addUser(User user) {
        users.addUser(user);
    }
    public int getUserBalance(User user) {
        return getUserBalance(user.getIdetifier());
    }
    public int getUserBalance(int id) {
        return users.getById(id).getBalance();
    }

    public String getUserName(int id) {
        return users.getById(id).getName();
    }

    public String getUserName(User user) {
        return getUserName(user.getIdetifier());
    }
    public void performTransaction(int senderId, int recipientId, int amount) {
        try {
            if (senderId == recipientId) {
                throw new IllegalTransferExeption();
            }
            User sender = users.getById(senderId);
            User recipient = users.getById(recipientId);
            if (sender.getBalance() < amount) {
                throw new IllegalTransferExeption();
            }
            Tranasction senderTransaction = new Tranasction(recipient, sender, Tranasction.Transfer_category.debits, -amount);
            Tranasction recipientTransaction = new Tranasction(senderTransaction.getIdentifier(), recipient, sender, Tranasction.Transfer_category.credits, amount);
            sender.addTransaction(senderTransaction);
            sender.setBalance(sender.getBalance() - amount);
            recipient.addTransaction(recipientTransaction);
            recipient.setBalance(recipient.getBalance() + amount);
        } catch (UserNotFoundExecption e) {
            throw  new IllegalTransferExeption();
        }
    }

    public Tranasction[] getTransactionArray(int userId) {
        return users.getById(userId).getTransactions();
    }

    public void removeTransaction(int userId, UUID transactionId) {
        try {
            users.getById(userId).removeTransaction(transactionId);
        } catch (TransactionNotFound e) {
            throw new UserNotFoundExecption();
        }
    }

    public Tranasction[] getIllegalTransactions() {
        TransactionLinkedList allTransactions = getAllTransactions();
        TransactionLinkedList illegalTransactions = new TransactionLinkedList();
        for (int i = 0; i < allTransactions.size; ++i) {
            if (allTransactions.countTransaction(allTransactions.getArray()[i].getIdentifier()) == 1) {
                illegalTransactions.addTransaction(allTransactions.getArray()[i]);
            }
        }
        return illegalTransactions.getArray();
    }

    private TransactionLinkedList getAllTransactions() {
        TransactionLinkedList allTransactions = new TransactionLinkedList();
        for (int i = 0; i < users.getiSize(); i++) {
            Tranasction[] tranasctions = users.getByIndex(i).getTransactions();
            for (int j = 0; j < tranasctions.length; ++j) {
                allTransactions.addTransaction(tranasctions[j]);
            }
        }
        return allTransactions;
    }
}
