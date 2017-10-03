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


public class Main extends Component{
    private JPanel  mainJPanel;
    private JButton espelharVerticalmenteButton;
    private JButton salvarButton;
    private JButton espelharHorizontalmenteButton;
    private JButton tonsDeCinzaButton;
    private JTextField nameSave;
    private JButton abrirButton;
    private JFrame changedImageFrame;
    private ImageLoader lastImageMade;
    static JFileChooser fc;
    static OriginalImageLoader originalImage;
    boolean jaAbriu = false;

    File file;

    public static void main(String[] args) {

        fc = new JFileChooser();

        JFrame frame = new JFrame("Main");
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.setContentPane(new Main().mainJPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private static void openPic(File file) {
        JFrame originalImageFrame = new JFrame("Original Image");


        originalImage = new OriginalImageLoader(file);

        originalImageFrame.add(originalImage);
        originalImageFrame.pack();
        originalImageFrame.setVisible(true);

    }

    public Main() {
        espelharVerticalmenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (changedImageFrame != null) {
                    changedImageFrame.remove(lastImageMade);
                    changedImageFrame.setTitle("Vertical flip");
                } else {
                    changedImageFrame = new JFrame("Vertical flip");
                }
                lastImageMade = new ImageLoader(ImageLoader.VERTICAL_FLIP, lastImageMade.img);
                changedImageFrame.add(lastImageMade);
                changedImageFrame.pack();
                changedImageFrame.setVisible(true);
            }
        });


        tonsDeCinzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (changedImageFrame != null) {
                    changedImageFrame.remove(lastImageMade);
                    changedImageFrame.setTitle("Grayscale");
                } else {
                    changedImageFrame = new JFrame("Grayscale");
                }
                lastImageMade = new ImageLoader(ImageLoader.GRAYSCALE, lastImageMade.img);
                changedImageFrame.add(lastImageMade);
                changedImageFrame.pack();
                changedImageFrame.setVisible(true);
            }
        });
        espelharHorizontalmenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (changedImageFrame != null) {
                    changedImageFrame.remove(lastImageMade);
                    changedImageFrame.setTitle("Horizontal flip");
                } else {
                    changedImageFrame = new JFrame("Horizontal flip");
                }
                lastImageMade = new ImageLoader(ImageLoader.HORIZONTAL_FLIP, lastImageMade.img);
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
                    File outputfile = new File(fileName + ".jpg");
                    ImageIO.write(bi, "jpg", outputfile);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        abrirButton.addActionListener(new ActionListener() {
            char newline = '\n';
            @Override
            public void actionPerformed(ActionEvent e) {
                //Handle open button action.
                if (e.getSource() == abrirButton) {
                    int returnVal = fc.showOpenDialog(Main.this);

                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        file = fc.getSelectedFile();
                        openPic(file);

                        lastImageMade = new ImageLoader(0, file);
                       System.out.println("Opening: " + file.getName() + "." + newline);
                    } else {
                        System.out.println("Open command cancelled by user." + newline);
                    }
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
