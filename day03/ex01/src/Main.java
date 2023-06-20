import Controller.Repeater;

public class Main {
    public static void main(String[] args){
        if (args.length != 1 || !args[0].matches("--count=\\d+")) {
            System.err.println("The program takes one argument, example: --count=50");
            System.exit(1);
        }
        int count = Integer.parseInt(args[0].split("=")[1]);
        Repeater egg = new Repeater(count, "Egg");
        Repeater hen = new Repeater(count, "Hen");
        egg.start();
        hen.start();
    }
}