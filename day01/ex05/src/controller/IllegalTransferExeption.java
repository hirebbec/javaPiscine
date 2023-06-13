package controller;

public class IllegalTransferExeption extends RuntimeException {
        @Override
        public String getMessage() {
            return "Illegal Transfer\n";
        }
}
