import java.io.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1 || !args[0].matches("--threadsCount=\\d+")) {
            System.err.println("Program takes one argument, example: --threadsCount=2");
            System.exit(1);
        }
        FileReader file = null;
        try {
            file = new FileReader("files_url.txt");
        } catch (FileNotFoundException e) {
            System.err.println("File 'files_urls.txt' does not exist!");
            System.exit(1);
        }
        BufferedReader bufferedReader = new BufferedReader(file);

    }
}