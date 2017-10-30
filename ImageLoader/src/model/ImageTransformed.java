package model;

import java.awt.image.BufferedImage;

public class ImageTransformed {

    private BufferedImage img;
    private static ImageTransformed instance;
    private int imgWidth;
    private int imgHeight;

    private ImageTransformed() {
    }
    public static synchronized ImageTransformed getInstance(){
        if (instance == null){
            instance = new ImageTransformed();
        }
        return instance;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
        this.imgWidth = img.getWidth();
        this.imgHeight = img.getHeight();
    }

    public BufferedImage getImageHorizontallyFlipped() {
        BufferedImage bi = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                int pixel = img.getRGB(i, j);
                bi.setRGB((imgWidth - 1 - i), j, pixel);
            }
        }
        this.img = bi;
        return img;
    }

    public BufferedImage getImageVerticallyFlipped() {
        BufferedImage bi = new BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                int pixel = img.getRGB(i, j);
                bi.setRGB(i, (imgHeight - 1 - j), pixel);
            }
        }
        this.img = bi;
        instance.setImg(bi);
        return img;
    }

    public BufferedImage getImageGrayscaled() {
        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                int pixel = img.getRGB(i, j);

                int a = (pixel >> 24) & 0xff;

                //get red
                int r = (pixel >> 16) & 0xff;

                //get green
                int g = (pixel >> 8) & 0xff;

                //get blue
                int b = pixel & 0xff;

                int l = (int) (0.299 * r + 0.587 * g + 0.114 * b);
                a = l;
                r = l;
                g = l;
                b = l;
                //set the pixel value
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(i, j, pixel);

            }
        }
        return img;
    }

    public BufferedImage getImageWithBright(int bright) {
        //this.setImg(OriginalImage.getInstance().getImg());
        int pixel;
        int a;
        int r;
        int g;
        int b;
        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                pixel = img.getRGB(i, j);

                a = (pixel >> 24) & 0xff;

                //get red
                r = (pixel >> 16) & 0xff;

                //get green
                g = (pixel >> 8) & 0xff;

                //get blue
                b = pixel & 0xff;

                a += bright;
                if (a < 0)
                    a = 0;
                if (a > 255)
                    a = 255;
                r += bright;
                if (r < 0)
                    r = 0;
                if (r > 255)
                    r = 255;
                g += bright;
                if (g < 0)
                    g = 0;
                if (g > 255)
                    g = 255;
                b += bright;
                if (b < 0)
                    b = 0;
                if (b > 255)
                    b = 255;

                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(i, j, pixel);
            }

        }
        return img;
    }
    public BufferedImage getImageNegative() {
        int pixel;
        int a;
        int r;
        int g;
        int b;
        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                pixel = img.getRGB(i, j);

                a = (pixel >> 24) & 0xff;

                //get red
                r = (pixel >> 16) & 0xff;

                //get green
                g = (pixel >> 8) & 0xff;

                //get blue
                b = pixel & 0xff;

                a = 255 - a;
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(i, j, pixel);
            }
        }
        return img;
    }
    public BufferedImage getImageConstrasted(int contrast) {
        int pixel;
        int a;
        int r;
        int g;
        int b;
        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                pixel = img.getRGB(i, j);

                a = (pixel >> 24) & 0xff;

                //get red
                r = (pixel >> 16) & 0xff;

                //get green
                g = (pixel >> 8) & 0xff;

                //get blue
                b = pixel & 0xff;

                a *= contrast;
                r *= contrast;
                g *= contrast;
                b *= contrast;
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                img.setRGB(i, j, pixel);
            }
        }
        return img;

    }
//    public BufferedImage getImageHorizontallyFlipped() {
//
//    }

}