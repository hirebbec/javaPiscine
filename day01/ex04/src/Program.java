import controller.TransactionLinkedList;
import controller.TransactionList;
import controller.TransactionService;
import models.Tranasction;
import models.User;

public class Program {
    public static void main(String[] args) {
        TransactionService transactionService = new TransactionService();
        User ruzel = new User("Ruzel", 10000);
        User liza = new User("Liza", 1000);

        transactionService.addUser(ruzel);
        transactionService.addUser(liza);

        transactionService.performTransaction(ruzel.getIdetifier(), liza.getIdetifier(), 100);
        transactionService.performTransaction(ruzel.getIdetifier(), liza.getIdetifier(), 200);
        transactionService.performTransaction(ruzel.getIdetifier(), liza.getIdetifier(), 300);
        transactionService.performTransaction(ruzel.getIdetifier(), liza.getIdetifier(), 400);
        transactionService.performTransaction(ruzel.getIdetifier(), liza.getIdetifier(), 500);
        transactionService.performTransaction(ruzel.getIdetifier(), liza.getIdetifier(), 600);
        transactionService.performTransaction(ruzel.getIdetifier(), liza.getIdetifier(), 700);

        System.out.println("Liza balance = " + transactionService.getUserBalance(liza));
        System.out.println("Ruzel balance = " + transactionService.getUserBalance(ruzel));

        transactionService.removeTransaction(ruzel.getTransactions()[0].getIdentifier(), ruzel.getIdetifier());

        Tranasction[] illegalTransactions = transactionService.getIllegalTransactions();
        for (Tranasction tranasction : illegalTransactions) {
            System.out.println(tranasction);
        }
    }
}