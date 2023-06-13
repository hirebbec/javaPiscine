package Controller;

import java.io.File;
import java.util.Scanner;

public class FileManager {
    private String currentPath;
    private static FileManager instance;
    private Scanner scanner;

    private FileManager() {
        this.currentPath = System.getProperty("user.dir");
    }

    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public void loop(){
        while (true) {
            scanner = new Scanner(System.in);
            String command = scanner.next();
            switch (command) {
                case "ls":
                    ls();
                    break;
                case "cd":
                    cd();
                    break;
                case "mv":
                    mv();
                    break;
                default:
                    System.err.println("Command not found!");;
            }
        }
    }

    private void ls() {
        File dir = new File(currentPath);
        if (dir.exists() && dir.isDirectory()) {
            for (File file : dir.listFiles()) {
                System.out.println(file.getName() + " " + file.length() + " bytes");
            }
        }
    }

    private void cd() {
        String path = scanner.next();
        File file = new File(path);
        if (file.isDirectory()) {
            currentPath = path;
            return;
        }
        file = new File(currentPath + "/" + path);
        if (file.isDirectory()) {
            currentPath = currentPath + "/" + path;
        } else if (file.isFile()) {
            System.err.println(path + " is not directory!");
        } else {
            System.err.println("no such file or directory: " + path);
        }
    }

    private void mv() {
        String path = scanner.next();
        String newPath = scanner.next();
        File file = new File(currentPath + "/" + path);
        if (file.exists()) {
            File newName = new File(currentPath + "/" +  newPath);
            if (newName.isDirectory()) {
                file.renameTo(new File(currentPath + "/" + newPath + "/" + path));
            } else if (!file.renameTo(newName)) {
                System.err.println("Failed to move!");
            }
        } else {
            System.err.println("no such file or directory: " + path);
        }
    }

    public String getCurrentPath() {
        return currentPath;
    }
}
