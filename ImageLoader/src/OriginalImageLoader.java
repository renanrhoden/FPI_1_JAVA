import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;
        import java.awt.*;
        import java.awt.event.*;
        import javax.swing.*;

        import javax.imageio.ImageIO;

public class OriginalImageLoader extends Component{


    BufferedImage img;


    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public OriginalImageLoader() {
        try {
            img = ImageIO.read(new File("/home/renanrhoden/IdeaProjects/FPI_1_JAVA/images/Gramado_22k.jpg"));
        } catch (IOException e) {
        }

    }

    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100,100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }

}