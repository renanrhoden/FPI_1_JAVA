import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;

public class ImageLoader extends Component {


    public static final int HORIZONTAL_FLIP = 2;
    public static final int VERTICAL_FLIP = 3;
    public static final int GRAYSCALE = 1;
    public BufferedImage img;
    private int action;

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public ImageLoader(int action) {
        this.action = action;
        try {
            img = ImageIO.read(new File("/home/renanrhoden/IdeaProjects/FPI_1_JAVA/images/Gramado_22k.jpg"));//get alpha
        } catch (IOException e) {
        }

        int imgHeight = img.getHeight();
        int imgWidth = img.getWidth();
        BufferedImage bi = new
                BufferedImage(imgWidth, imgHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics biGraphics = bi.getGraphics();

        for (int i = 0; i < imgWidth; i++) {
            for (int j = 0; j < imgHeight; j++) {
                int pixel = img.getRGB(i, j);


                if (action == HORIZONTAL_FLIP)
                    bi.setRGB((imgWidth - 1 - i), j, pixel);


                if (action == VERTICAL_FLIP)
                    bi.setRGB(i, (imgHeight - 1 - j), pixel);

                int a = (pixel >> 24) & 0xff;

                //get red
                int r = (pixel >> 16) & 0xff;

                //get green
                int g = (pixel >> 8) & 0xff;

                //get blue
                int b = pixel & 0xff;


                //grayscale
                if (action == GRAYSCALE) {
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
        }

        if (action == HORIZONTAL_FLIP)
            img = bi;


        if (action == VERTICAL_FLIP)
            img = bi;


    }

    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100, 100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }
}

//brilho
//                    a -= 50;
//                    if (a < 0)
//                        a = 0;
//                    r -= 50;
//                    if (r < 0)
//                        r = 0;
//                    g -= 50;
//                    if (g < 0)
//                        g = 0;
//                    b -= 50;
//                    if (b < 0)
//                        b = 0;