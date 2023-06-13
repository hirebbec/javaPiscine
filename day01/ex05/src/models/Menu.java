package models;

import controller.IllegalTransferExeption;
import controller.TransactionList;
import controller.TransactionService;
import controller.UserNotFoundExecption;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
    TransactionService service;
    private boolean dev;

    public Menu(boolean dev) {
        this.dev = dev;
        service = new TransactionService();
    }

    public void printMenu() {
        System.out.println("1. Add a user");
        System.out.println("2. View user balances");
        System.out.println("3. Perform a transfer");
        System.out.println("4. View all transaction for a specific user");
        if (dev) {
            System.out.println("5. DEV - remove a transfer by ID");
            System.out.println("6. DEV - check tarnsfer validity");
            System.out.println("7. Finish execution");
        } else {
            System.out.println("5. Finish execution");
        }
    }

    public void executeOperation(int operation) {
        switch (operation) {
            case 1:
                addUser();
                break;
            case 2:
                printUserBalance();
                break;
            case 3:
                performTransfer();
                break;
            case 4:
                printTransactionsForUser();
                break;
            case 5:
            {
                if (dev) {
                    removeTransfer();
                } else {
                    System.exit(0);
                }
                break;
            }
            case 6:
                if (dev) {
                    printIllegalTransfers();
                } else {
                    System.err.println("Operation not found");
                }
                break;
            case 7:
                if (dev) {
                    System.exit(0);
                } else {
                    System.err.println("Operation not found");
                }
                break;
            default:
                System.err.println("Operation not found");
        }
    }

    private void addUser() {
        System.out.println("Enter a user name and balance");
        Scanner scanner = new Scanner(System.in);
        User newUser = new User(scanner.next(), scanner.nextInt());
        service.addUser(newUser);
        System.out.println("User with id = " + newUser.getIdetifier() + " is added");
    }

    private void printUserBalance() {
        System.out.println("Enter a user ID");
        Scanner scanner = new Scanner(System.in);
        try {
            int ID = scanner.nextInt();
            System.out.println(service.getUserName(ID) + " - " + service.getUserBalance(ID));
        } catch (UserNotFoundExecption e) {
            System.err.println("User with this ID doesn't exists");
        }
    }

    private void performTransfer() {
        System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
        Scanner scanner = new Scanner(System.in);
        try {
            service.performTransaction(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            System.out.println("The transfer is completed");
        } catch (IllegalTransferExeption e) {
            System.err.println("Illegal transfer");
        }
    }

    private void printTransactionsForUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a user ID");
        Tranasction[] tranasctions = service.getTransactionArray(scanner.nextInt());
        for (Tranasction tranasction : tranasctions) {
            System.out.println(tranasction);
        }
    }

    private void removeTransfer() {
        System.out.println("Enter a user ID and a Transfer ID");
        Scanner scanner = new Scanner(System.in);
        try {
            service.removeTransaction(scanner.nextInt(), UUID.fromString(scanner.next()));
        } catch (UserNotFoundExecption e) {
            System.err.println("Illegal operation");
        }
    }

    private void printIllegalTransfers() {
        Scanner scanner = new Scanner(System.in);
        Tranasction[] tranasctions = service.getIllegalTransactions();
        if (tranasctions.length == 0) {
            System.out.println("Illegal transactions not found");
        } else {
            System.out.println("Check results");
            for (Tranasction tranasction : tranasctions) {
                System.out.println(tranasction.getRecicient().getName()
                        + "(id = " + tranasction.getRecicient().getIdetifier()
                        + ") has an unacknowledged id = " + tranasction.getIdentifier()
                        + " from " + tranasction.getSender().getName() + "(id = "
                        + tranasction.getSender().getIdetifier() + ") for " + tranasction.getAmount());
            }
        }
    }
}

