package Controller;

import Model.DownoloadThread;

public class DownoloadManager {
    private DownoloadThread[] threads;
    private String[] urls;
    private int i;

    private int threadsCount;

    public DownoloadManager(int threadsCount, String[] urls) {
        this.threadsCount = threadsCount;
        this.threads = new DownoloadThread[threadsCount];
        this.urls = urls;
        i = 0;
    }

    public String getUrl() {
        if (urls.length < i) {
            return urls[i++];
        } else
            return null;
    }

    public void downoload() {
        for (DownoloadThread thread : threads) {
            thread.start();
        }
    }
}
