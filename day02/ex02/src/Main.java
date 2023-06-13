import Controller.FileManager;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = FileManager.getInstance();
        fileManager.loop();
    }
}