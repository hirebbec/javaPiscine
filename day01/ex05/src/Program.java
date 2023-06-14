import controller.TransactionLinkedList;
import controller.TransactionList;
import controller.TransactionService;
import models.Menu;
import models.Tranasction;
import models.User;

import java.util.Scanner;
import java.util.UUID;

public class Program {
    public static void main(String[] args) {
        if (args.length != 1 || !(args[0].equals("--profile=dev") || args[0].equals("--profile=production"))) {
            System.err.println("Please select program mode(dev or production)");
            System.err.println("Example --profile=dev");
            return;
        }
        Menu menu = new Menu(args[0].equals("--profile=dev"));
        while (true) {
            Scanner scanner =  new Scanner(System.in);
            menu.printMenu();
            menu.executeOperation(scanner.nextInt());
        }
    }
}