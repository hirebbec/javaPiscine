package Controller;

public class Repeater extends Thread {
    int count;
    String message;
    private static final Object lock = new Object();

    public Repeater(int count, String message) {
        this.count = count;
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (lock) {
            for (int i = 0; i < count; ++i) {
                lock.notifyAll();
                System.out.println(message);
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            lock.notifyAll();
        }
    }
}
