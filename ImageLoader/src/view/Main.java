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
    private JFrame changedImageFrame;


    public Main() {

        this.setTitle("Main");
        this.setContentPane(mainJPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }
}
