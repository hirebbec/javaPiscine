import controller.TransactionLinkedList;
import controller.TransactionList;
import models.Tranasction;
import models.User;

public class Program {
    public static void main(String[] args) {
        User ruzel = new User("Ruzel", 1000);
        User liza = new User("Liza", 2000);
        TransactionList transactionList = new TransactionLinkedList();
        Tranasction tranasction1 = new Tranasction(ruzel, liza, Tranasction.Transfer_category.debits, -100);
        Tranasction tranasction2 =  new Tranasction(ruzel, liza, Tranasction.Transfer_category.credits, 200);
        Tranasction tranasction3 = new Tranasction(liza, ruzel, Tranasction.Transfer_category.credits, 301);
        transactionList.addTransaction(tranasction1);
        transactionList.addTransaction(tranasction2);
        transactionList.addTransaction(tranasction3);
        Tranasction[] tranasctions = transactionList.getArray();
        for (Tranasction tranasction : tranasctions) {
            System.out.println(tranasction);
        }
        System.out.println("================================");
        transactionList.removeTransaction(tranasction2.getIdentifier());
        tranasctions = transactionList.getArray();
        for (Tranasction tranasction : tranasctions) {
            System.out.println(tranasction);
        }
        System.out.println("================================");
        transactionList.removeTransaction(tranasction1.getIdentifier());
        tranasctions = transactionList.getArray();
        for (Tranasction tranasction : tranasctions) {
            System.out.println(tranasction);
        }
        System.out.println("================================");
        transactionList.removeTransaction(tranasction3.getIdentifier());
        tranasctions = transactionList.getArray();
        for (Tranasction tranasction : tranasctions) {
            System.out.println(tranasction);
        }
    }
}