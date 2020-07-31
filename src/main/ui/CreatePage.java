package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePage extends JPanel implements ActionListener {

    private static final String[] MUSICTYPES = {"HIPHOP", "JAZZ", "ROCK", "ELECTRONIC"};

    public CreatePage() {
        createPanel();
        addComponents();
        addMoreComponents();
    }

    private void addMoreComponents() {
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("sans-serif", Font.PLAIN, 20));
        name.setLocation(50,30);
        name.setSize(100,30);

        JTextField text = new JTextField();
        text.setLocation(150,30);
        text.setSize(new Dimension(240,30));
        this.putClientProperty("NameSelect", text);

        this.add(name);
        this.add(text);
    }

    private void createPanel() {
        this.setLayout(null);

        JLabel genre = new JLabel("Genre:");
        genre.setFont(new Font("sans-serif", Font.PLAIN, 20));
        genre.setLocation(50,120);
        genre.setSize(100,30);

        JLabel tempo = new JLabel("Tempo:");
        tempo.setFont(new Font("sans-serif", Font.PLAIN, 20));
        tempo.setLocation(50,220);
        tempo.setSize(100,30);

        JTextField text = new JTextField();
        text.setLocation(150,220);
        text.setSize(new Dimension(240,30));
        this.putClientProperty("TempoSelect", text);

        JComboBox comboBox = new JComboBox(MUSICTYPES);
        comboBox.setLocation(150,120);
        comboBox.setSize(new Dimension(250,30));
        this.putClientProperty("TypeSelect", comboBox);


        this.add(genre);
        this.add(comboBox);
        this.add(tempo);
        this.add(text);
    }


    private void addComponents() {

        JLabel genre = new JLabel("Set Stressed Beats?");
        genre.setFont(new Font("sans-serif", Font.PLAIN, 20));
        genre.setLocation(50,300);
        genre.setSize(200,30);

        JButton nextButton = new JButton("Next");
        nextButton.setLocation(300, 370);
        nextButton.setSize(new Dimension(100,30));
        nextButton.addActionListener(this);

        JButton backButton = new JButton("Back");
        backButton.setLocation(50, 370);
        backButton.setSize(new Dimension(100,30));
        backButton.addActionListener(this);

        JCheckBox checkBoxStress = new JCheckBox();
        checkBoxStress.setBounds(0,0,50,50);
        checkBoxStress.setLocation(300,295);
        this.putClientProperty("StressSelect", checkBoxStress);

        this.add(backButton);
        this.add(nextButton);
        this.add(genre);
        this.add(checkBoxStress);

    }

    private boolean validateInputs() {
        JTextField name = (JTextField) this.getClientProperty("NameSelect");
        JTextField tempo = (JTextField) this.getClientProperty("TempoSelect");
        try {
            String nameStr = name.getText();
            if (nameStr.length() < 1 || nameStr.length() > 20) {
                GUI.showDialog("Invalid name format!");
                return false;
            }
            int tempoNum = Integer.parseInt(tempo.getText());
            if (tempoNum <= 20 || tempoNum >= 400) {
                GUI.showDialog("Invalid tempo, choose tempo between 20 - 400!");
                return false;
            }

        } catch (NumberFormatException e) {
            GUI.showDialog("Invalid Tempo Format!");
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Next")) {
            if (validateInputs()) {
                sendInputs();
            }
        } else if (action.equals("Back")) {
            GUI.processAction(GUI.command.get("BACK"));
        }
    }

    private void sendInputs() {
        JTextField name = (JTextField) this.getClientProperty("NameSelect");
        JTextField tempo = (JTextField) this.getClientProperty("TempoSelect");
        JComboBox type = (JComboBox) this.getClientProperty("TypeSelect");
        JCheckBox stress = (JCheckBox) this.getClientProperty("StressSelect");

        GUI.receiveCreatePageInputs(name.getText(), Integer.parseInt(tempo.getText()),
                MUSICTYPES[type.getSelectedIndex()], stress.isSelected());
    }
}
