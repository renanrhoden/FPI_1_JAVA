package controller;

import com.sun.istack.internal.Nullable;
import model.Histogram;
import model.ImageTransformed;
import model.OriginalImage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.statistics.HistogramDataset;
import view.ImageComponent;
import view.Main;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class Controller implements ActionListener, ChangeListener {

    public static final String GRAYSCALE = "Grayscale";
    public static final String VERTICAL_FLIP = "VerticalFlip";
    public static final String HORIZONTAL_FLIP = "HorizontalFlip";
    public static final String BRIGHT = "bright";
    public static final String NEGATIVO = "negativo";
    public static final String CONTRASTE = "Contraste";
    private Main main;
    private JFileChooser fc;
    private JFrame frame;
    private Component component;

    public Controller(Main main) {
        fc = new JFileChooser();
        frame = new JFrame();
        this.main = main;
        this.main.getEspelharVerticalmenteButton().addActionListener(this);
        this.main.getAbrirButton().addActionListener(this);
        this.main.getEspelharHorizontalmenteButton().addActionListener(this);
        this.main.getTonsDeCinzaButton().addActionListener(this);
        this.main.getBrilhoSlider().addChangeListener(this);
        this.main.getNegativoButton().addActionListener(this);
        this.main.getContrastSpinner().addChangeListener(this);
        this.main.getHistogramaButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == main.getEspelharVerticalmenteButton()) {

            if (setNewImage(VERTICAL_FLIP, null)) return;
            frame.pack();
            frame.setVisible(true);
        }
        if (actionEvent.getSource() == main.getTonsDeCinzaButton()) {
            if (setNewImage(GRAYSCALE, null)) return;
            frame.pack();
            frame.setVisible(true);
        }
        if (actionEvent.getSource() == main.getHistogramaButton()) {
            Histogram histogram = new Histogram(ImageTransformed.getInstance().getImageGrayscaled());
            int [] normalizedValues = histogram.getNormalizedValues();
            JPanel chartPanel;
            double[] nDouble = new double[256];
            for (int i = 0; i < normalizedValues.length; i++) {
                nDouble[i] = normalizedValues[i];
            }
            HistogramDataset data = new HistogramDataset();
            data.addSeries("Histogram", nDouble, 10);

            String plotTitle = "Histogram";
            String xaxis = "number";
            String yaxis = "value";
            PlotOrientation orientation = PlotOrientation.VERTICAL;
            boolean show = false;
            boolean toolTips = false;
            boolean urls = false;
            int width = 500;
            int height = 300;
            JFreeChart chart = ChartFactory.createHistogram( plotTitle, xaxis, yaxis,
                    data, orientation, show, toolTips, urls);
                frame = new ChartFrame("Teste", chart);
            frame.pack();
            frame.setVisible(true);
        }

        if (actionEvent.getSource() == main.getEspelharHorizontalmenteButton()){
            if (setNewImage(HORIZONTAL_FLIP, null)) return;
            frame.pack();
            frame.setVisible(true);
        }
        if (actionEvent.getSource() == main.getNegativoButton()){
            if (setNewImage(NEGATIVO, null)) return;
            frame.pack();
            frame.setVisible(true);
        }

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
    }

    private boolean setNewImage(String action, @Nullable Double bright) {
        if (OriginalImage.getInstance().getImg() == null) {
            return true;
        }
        frame.setTitle(action);
        BufferedImage image;
        if (ImageTransformed.getInstance().getImg() == null) {
            ImageTransformed.getInstance().setImg(OriginalImage.getInstance().getImg());
        }
        switch (action) {
            case GRAYSCALE:
                image = ImageTransformed.getInstance().getImageGrayscaled();
                break;
            case VERTICAL_FLIP:
                image = ImageTransformed.getInstance().getImageVerticallyFlipped();
                break;
            case HORIZONTAL_FLIP:
                image = ImageTransformed.getInstance().getImageHorizontallyFlipped();
                break;
            case BRIGHT:
                image = ImageTransformed.getInstance().getImageWithBright(bright.intValue());
                break;
            case NEGATIVO:
                image =  ImageTransformed.getInstance().getImageNegative();
                break;
            case CONTRASTE:
                image = ImageTransformed.getInstance().getImageConstrasted(bright);
                break;
            default:
                image = null;
        }

        if (component != null) {
            frame.remove(component);
        }

        component = new ImageComponent(image);
        frame.add(component);
        return false;
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        if (changeEvent.getSource() == main.getBrilhoSlider()){
            JSlider slider = (JSlider)changeEvent.getSource();
            int bright = slider.getValue();
            if (setNewImage(BRIGHT, (double)bright)) return;
            frame.pack();
            frame.setVisible(true);
        }
        if (changeEvent.getSource() == main.getContrastSpinner()){
            JSpinner source = (JSpinner)changeEvent.getSource();
            double contrast = (double)source.getValue();
            if (setNewImage(CONTRASTE, contrast)) return;
            frame.pack();
            frame.setVisible(true);
        }
    }
}
