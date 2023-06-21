package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Printer {
    private BufferedImage image;
    private char whiteChar;
    private char blackChar;

    public Printer(char whiteChar, char blackChar) {
        this.whiteChar = whiteChar;
        this.blackChar = blackChar;
    }

    public void openImage(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printImage() {
        for (int i = 0; i < image.getHeight(); ++i) {
            for (int j = 0; j < image.getWidth(); ++j) {
                if (image.getRGB(i, j) == Color.WHITE.getRGB()) {
                    System.out.print('.');
                } else {
                    System.out.print('0');
                }
            }
            System.out.println();
        }
    }
}
