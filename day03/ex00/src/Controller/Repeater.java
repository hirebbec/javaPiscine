package Controller;

public class Repeater extends Thread {
    int count;
    String message;

    public Repeater(int count, String message) {
        this.count = count;
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; ++i) {
            System.out.println(message);
        }
    }
}
