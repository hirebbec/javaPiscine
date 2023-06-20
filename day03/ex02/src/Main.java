import Controller.Counter;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2 ||
                !args[0].matches("--arraySize=\\d+") ||
                !args[1].matches("--threadsCount=\\d+")) {
            System.err.println("Program takes two argument, example: --arraySize=10 --threadsCount=2");
            System.exit(1);
        }

        int arraySize = Integer.parseInt(args[0].split("=")[1]);
        int threadsCount = Integer.parseInt(args[1].split("=")[1]);
        int randomNumbers[] = new int[arraySize];
        Random random = new Random();

        for (int i = 0; i < arraySize; ++i) {
            randomNumbers[i] = random.nextInt(1, 100);
        }

        Counter counter = new Counter(randomNumbers, threadsCount);
        counter.count();
    }
}