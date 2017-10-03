import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Main {
    private JPanel  mainJPanel;
    private JButton espelharVerticalmenteButton;
    private JButton salvarButton;
    private JButton espelharHorizontalmenteButton;
    private JButton tonsDeCinzaButton;
    private JTextField nameSave;
    private JFrame changedImageFrame;
    private ImageLoader lastImageMade;

    public static void main(String[] args) {

        JFrame originalImageFrame = new JFrame("Original Image");

        originalImageFrame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        originalImageFrame.add(new OriginalImageLoader());
        originalImageFrame.pack();
        originalImageFrame.setVisible(true);


        JFrame frame = new JFrame("Main");
        frame.setContentPane(new Main().mainJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Main() {
        espelharVerticalmenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                changedImageFrame = new JFrame("Load Image Sample");
                lastImageMade = new ImageLoader(ImageLoader.VERTICAL_FLIP);
                changedImageFrame.add(lastImageMade);
                changedImageFrame.pack();
                changedImageFrame.setVisible(true);
            }
        });


        tonsDeCinzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                changedImageFrame = new JFrame("Grayscale");
                lastImageMade = new ImageLoader(ImageLoader.GRAYSCALE);
                changedImageFrame.add(lastImageMade);
                changedImageFrame.pack();
                changedImageFrame.setVisible(true);
            }
        });
        espelharHorizontalmenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                changedImageFrame = new JFrame("Grayscale");

                lastImageMade = new ImageLoader(ImageLoader.HORIZONTAL_FLIP);
                changedImageFrame.add(lastImageMade);
                changedImageFrame.pack();
                changedImageFrame.setVisible(true);
            }
        });

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    // retrieve image
                    String fileName = nameSave.getText();
                    BufferedImage bi = lastImageMade.img;
                    File outputfile = new File("fileName" + ".jpg");
                    ImageIO.write(bi, "jpg", outputfile);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    public void setData(Main data) {
    }

    public void getData(Main data) {
    }

    public boolean isModified(Main data) {
        return false;
    }
}
