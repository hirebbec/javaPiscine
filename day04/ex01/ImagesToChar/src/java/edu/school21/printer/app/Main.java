package edu.school21.printer.app;

import edu.school21.printer.logic.Printer;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2 || args[0].length() != 1 || args[1].length() != 1) {
            System.err.println("Program takes 2 arguments, 2 characters");
            System.exit(1);
        }
        Printer printer = new Printer(args[0].charAt(0), args[1].charAt(0));
        printer.openImage("./target/resources/it.bmp");
        printer.printImage();
    }
}