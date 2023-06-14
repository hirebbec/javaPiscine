package models;

import java.util.UUID;

public class Tranasction {

    public enum Transfer_category {
        debits,
        credits;
    }
    UUID Identifier;
    User Recicient;
    User Sender;

    public UUID getIdentifier() {
        return Identifier;
    }

    public User getRecicient() {
        return Recicient;
    }

    @Override
    public String toString() {
        String categoryStr;
        if (category == Transfer_category.credits)
            categoryStr = "Credit";
        else
            categoryStr = "Debit";
        return "Tranasction{" +
                "Identifier=" + Identifier +
                ", Recicient=" + Recicient +
                ", Sender=" + Sender +
                ", category=" + categoryStr +
                ", amount=" + amount +
                '}';
    }

    public User getSender() {
        return Sender;
    }

    public Transfer_category getCategory() {
        return category;
    }

    public int getAmount() {
        return amount;
    }

    Transfer_category category;
    int amount;

    public Tranasction(User recicient, User sender, Transfer_category category, int amount) {
        this.Identifier = UUID.randomUUID();
        this.Recicient = recicient;
        this.Sender = sender;
        this.category = category;
        if (category == Transfer_category.credits && amount > 0 || category == Transfer_category.debits && amount < 0) {
            this.amount = amount;
        } else {
            amount = 0;
        }
    }

    public Tranasction(UUID identifier, User recicient, User sender, Transfer_category category, int amount) {
        Identifier = identifier;
        Recicient = recicient;
        Sender = sender;
        this.category = category;
        if (category == Transfer_category.credits && amount > 0 || category == Transfer_category.debits && amount < 0) {
            this.amount = amount;
        } else {
            amount = 0;
        }
    }


}
