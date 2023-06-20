package Controller;

import Model.DownoloadThread;

import java.util.List;

public class DownoloadManager {
    private DownoloadThread[] threads;
    private List<String> urls;
    private int i;

    private int threadsCount;

    public DownoloadManager(int threadsCount, List<String> urls) {
        this.threadsCount = threadsCount;
        this.threads = new DownoloadThread[threadsCount];
        this.urls = urls;
        i = 0;
    }

    public int getNum() {
        if (i < urls.size()) {
            return i++;
        } else
            return -1;
    }

    public List getUrls() {
        return urls;
    }

    public void downoload() {
        for (int i = 0; i < threadsCount; ++i) {
            threads[i] = new DownoloadThread(this);
            threads[i].start();
        }
        for (int i = 0; i < threadsCount; ++i) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
