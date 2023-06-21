package controller;

public class TransactionNotFound extends RuntimeException{
    @Override
    public String getMessage() {
        return "Transaction not Found!\n";
    }
}
