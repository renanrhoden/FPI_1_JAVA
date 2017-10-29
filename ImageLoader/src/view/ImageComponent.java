package view;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageComponent extends Component {
    BufferedImage img;

    public ImageComponent(BufferedImage img) {
        this.img = img;
    }

    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100,100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}
