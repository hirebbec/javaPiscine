package models;

import java.util.UUID;

public class Tranasction {

    enum Transfer_category {
        debits,
        credits
    }
    UUID Identifier;
    User Recicient;
    User Sender;
    Transfer_category category;
    int amount;

    public Tranasction(User recicient, User sender, Transfer_category category, int amount) {
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
