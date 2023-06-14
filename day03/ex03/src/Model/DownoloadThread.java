package Model;

import Controller.DownoloadManager;

public class DownoloadThread extends Thread {

    DownoloadManager manager;
    public DownoloadThread(DownoloadManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            String url = manager.getUrl();
        }
    }
}
