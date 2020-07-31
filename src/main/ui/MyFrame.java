package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MyFrame {
    private JFrame myFrame;
    private static final int WIDTH = 480;
    private static final int HEIGHT = 480;

    public MyFrame(JPanel panel) {
        myFrame = new JFrame("Beat Maker");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.getContentPane().setBackground(new Color(250, 228, 202));
        myFrame.setSize(WIDTH, HEIGHT);

        myFrame.getContentPane().add(panel);

        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);

    }

    public void changeToHomePanel(JPanel panel) {
        myFrame.setContentPane(panel);
        myFrame.validate();
        myFrame.repaint();
        setBackground();
    }

    public void changePanel(JPanel panel) {
        myFrame.setContentPane(panel);
        myFrame.repaint();
        myFrame.revalidate();
    }

    public void closeWindow() {
        myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));
    }

    public void showDialog(String display) {
        JOptionPane.showMessageDialog(myFrame, display);
    }

    private void setBackground() {
        myFrame.setBackground(new Color(250, 228, 202));
    }

}
