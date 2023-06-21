package models;

import java.util.UUID;

public class Tranasction {

    public enum Transfer_category {
        debits,
        credits;
    }
    private UUID Identifier;
    private User Recicient;
    private User Sender;
    private Transfer_category category;
    private int amount;

    public UUID getIdentifier() {
        return Identifier;
    }

    public User getRecicient() {
        return Recicient;
    }

    @Override
    public String toString() {
        if (category .equals(Transfer_category.debits)) {
            return "To " + Recicient.getName()
                    + "(id = " + Recicient.getIdetifier() + ") "
                    + amount + " with id = " + Identifier;
        } else {
            return "From " + Sender.getName()
                    + "(id = " + Sender.getIdetifier() + ") "
                    + amount + " with id = " + Identifier;
        }
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
