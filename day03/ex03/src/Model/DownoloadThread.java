package Model;

import Controller.DownoloadManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DownoloadThread extends Thread {

    DownoloadManager manager;
    public DownoloadThread(DownoloadManager manager) {
        this.manager = manager;
    }

    @Override
    public void run() {
        while (true) {
            int num = manager.getNum();
            if (num == -1) {
                return;
            }
            System.out.println(Thread.currentThread().getName() + " start download file number " + num);
            try {
                URL url = new URL((String) manager.getUrls().get(num));
                String fileName = "files/" + num;
                Path outputPath = Path.of(fileName);
                Files.copy(url.openStream(), outputPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println(Thread.currentThread().getName() + " finish download file number " + num);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
