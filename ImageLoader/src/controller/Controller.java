package controller;

import model.ImageTransformed;
import model.OriginalImage;
import view.ImageComponent;
import view.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Controller implements ActionListener {

    private Main main;
    private JFileChooser fc;

    public Controller(Main main) {
        fc = new JFileChooser();
        this.main = main;
        this.main.getEspelharVerticalmenteButton().addActionListener(this);
        this.main.getAbrirButton().addActionListener(this);
        this.main.getEspelharHorizontalmenteButton().addActionListener(this);
        this.main.getTonsDeCinzaButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() ==main.getEspelharVerticalmenteButton()){
            if (OriginalImage.getInstance().getImg() == null){
                return;
            }
            JFrame frame = new JFrame("VerticalFlip");
            BufferedImage image;
            ImageTransformed transformed = new ImageTransformed(OriginalImage.getInstance().getImg());
            image = transformed.getImageVerticallyFlipped();
            frame.add(new ImageComponent(image));
            frame.pack();
            frame.setVisible(true);
        }
        if (actionEvent.getSource() == this.main.getAbrirButton()) {
            int returnVal = fc.showOpenDialog(main);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                System.out.println("Opening: " + file.getName() + ".");
                JFrame frame = new JFrame("Original");
                frame.add(new ImageComponent(OriginalImage.getInstance().loadImg(file)));
                frame.pack();
                frame.setVisible(true);

            } else {
                System.out.println("Open command cancelled by user.");
            }
        }

        if (actionEvent.getSource() == main.getTonsDeCinzaButton()){
            if (OriginalImage.getInstance().getImg() == null){
                return;
            }
            JFrame frame = new JFrame("VerticalFlip");
//            BufferedImage image = OriginalImage.getInstance().loadImg(new File("/home/renanrhoden/IdeaProjects/FPI_1_JAVA/images/Gramado_22k.jpg"));
            ImageTransformed transformed = new ImageTransformed(OriginalImage.getInstance().getImg());
            frame.add(new ImageComponent(transformed.getImageGrayscaled()));
            frame.pack();
            frame.setVisible(true);
        }

        if (actionEvent.getSource() == main.getEspelharHorizontalmenteButton()){
            if (OriginalImage.getInstance().getImg() == null){
                return;
            }
            JFrame frame = new JFrame("HorizontalFlip");
            ImageTransformed transformed = new ImageTransformed(OriginalImage.getInstance().getImg());
            frame.add(new ImageComponent(transformed.getImageHorizontallyFlipped()));
            frame.pack();
            frame.setVisible(true);
        }
//
//        if (actionEvent.getSource() == main.getSalvarButton()){
//            try {
//                // retrieve image
//                String fileName = nameSave.getText();
//                BufferedImage bi = lastImageMade.img;
//                File outputfile = new File("fileName" + ".jpg");
//                ImageIO.write(bi, "jpg", outputfile);
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//
//        }
    }
}
