import Controller.DownoloadManager;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1 || !args[0].matches("--threadsCount=\\d+")) {
            System.err.println("Program takes one argument, example: --threadsCount=2");
            System.exit(1);
        }
        FileReader file = null;
        try {
            file = new FileReader("./files_url.txt");
        } catch (FileNotFoundException e) {
            System.err.println("File 'files_url.txt' does not exist!");
            System.exit(1);
        }

        int threadsCount = Integer.parseInt(args[0].split("=")[1]);
        BufferedReader bufferedReader = new BufferedReader(file);
        List<String> urls = new ArrayList<>();
        String url;
        try {
            while ((url = bufferedReader.readLine()) != null) {
                urls.add(url.split(" ")[1]);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        DownoloadManager manager = new DownoloadManager(threadsCount, urls);
        manager.downoload();
    }
}