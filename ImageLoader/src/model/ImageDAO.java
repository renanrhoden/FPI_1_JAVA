package model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.swing.JOptionPane.showMessageDialog;

public class ImageDAO {
    BufferedImage img;

    public static BufferedImage open(File file){
        BufferedImage img;
        try {
            img = ImageIO.read(file);
            return img;
        } catch (IOException e) {
            showMessageDialog(null,
                    "WARNING.",
                    "Sorry, I was unable to open this file",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

}
