package model;

import java.awt.image.BufferedImage;
import java.io.File;

public class OriginalImage {
    private BufferedImage img;
    private static OriginalImage instance;

    private OriginalImage() {

    }

    public BufferedImage getImg() {
        return img;
    }

    public BufferedImage loadImg(File file) {
        this.img = ImageDAO.open(file);
        ImageTransformed.getInstance().setImg(img);
        return this.img;
    }

    public static synchronized OriginalImage getInstance(){
        if (instance == null){
            instance = new OriginalImage();
        }
        return instance;
    }
}
