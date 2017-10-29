import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader extends Component {

    public BufferedImage img;
    private int action;

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    public ImageLoader(int action, File file) {
        try {
            img = ImageIO.read(file);
        } catch (IOException e) {
        }
    }

    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100, 100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }
}