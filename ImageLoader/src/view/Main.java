package view;

import javax.swing.*;


public class Main extends JFrame{
    private JPanel mainJPanel;
    private JButton espelharVerticalmenteButton;

    public JPanel getMainJPanel() {
        return mainJPanel;
    }

    public JButton getEspelharVerticalmenteButton() {
        return espelharVerticalmenteButton;
    }

    public JButton getSalvarButton() {
        return salvarButton;
    }

    public JButton getEspelharHorizontalmenteButton() {
        return espelharHorizontalmenteButton;
    }

    public JButton getTonsDeCinzaButton() {
        return tonsDeCinzaButton;
    }

    public JTextField getNameSave() {
        return nameSave;
    }

    public JButton getAbrirButton() {
        return abrirButton;
    }

    public JFrame getChangedImageFrame() {
        return changedImageFrame;
    }

    private JButton salvarButton;
    private JButton espelharHorizontalmenteButton;
    private JButton tonsDeCinzaButton;
    private JTextField nameSave;
    private JButton abrirButton;

    public JSlider getBrilhoSlider() {
        return brilhoSlider;
    }

    private JSlider brilhoSlider;
    private JTextField brilhoTextField;

    public JButton getNegativoButton() {
        return negativoButton;
    }

    private JButton negativoButton;

    public JSpinner getContrastSpinner() {
        return contrastSpinner;
    }

    private JSpinner contrastSpinner;
    private JFrame changedImageFrame;


    public Main() {

        this.setTitle("Main");
        this.setContentPane(mainJPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        contrastSpinner.setModel(new SpinnerNumberModel(0.1, 0, 255, 0.001));
    }
}
