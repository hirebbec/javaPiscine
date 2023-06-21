package edu.school21.printer.logic;

import com.diogonunes.jcolor.Attribute;
import com.diogonunes.jcolor.Ansi;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Printer {
    private String white;
    private String black;

    public Printer(String white, String black) {
        this.white = white;
        this.black = black;
    }

    public void drawImage(File file) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(file);
        for (int i = 0; i < bufferedImage.getHeight(); i++) {
            for (int j = 0; j < bufferedImage.getWidth(); j++) {
                int color = bufferedImage.getRGB(j, i);
                if (color == Color.WHITE.getRGB()) {
                    System.out.print(Ansi.colorize(" ", resolveColor(white)));
                } else {
                    System.out.print(Ansi.colorize(" ", resolveColor(black)));
                }
            }
            System.out.println();
        }
    }

    private Attribute resolveColor(String input) {
        switch (input) {
            case "RED":
                return (Attribute.RED_BACK());
            case "GREEN":
                return (Attribute.GREEN_BACK());
            case "BLUE":
                return (Attribute.BLUE_BACK());
            case "BLACK":
                return (Attribute.BLACK_BACK());
            case "WHITE":
                return (Attribute.WHITE_BACK());
            case "YELLOW":
                return (Attribute.YELLOW_BACK());
            case "CYAN":
                return (Attribute.CYAN_BACK());
            case "MAGENTA":
                return (Attribute.MAGENTA_BACK());
            default:
                return (Attribute.NONE());
        }

    }
}
