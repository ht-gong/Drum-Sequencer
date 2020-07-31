package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateStressPage extends JPanel implements ActionListener {

    private String name;
    private int tempo;
    private String genre;
    private String[] stressArray;
    ArrayList<Integer> stressedBeats;

    public CreateStressPage(String name, int tempo, String genre) {
        this.name = name;
        this.tempo = tempo;
        this.genre = genre;
        stressedBeats = new ArrayList<>();
        if (genre. equals("JAZZ") || genre.equals("HIPHOP")) {
            stressArray = new String[]{"1", "2", "3"};
        } else if (genre.equals("ELECTRONIC") || genre.equals("ROCK")) {
            stressArray = new String[]{"1", "2", "3", "4"};
        }
        createPanel();
        addComponents();
    }

    private void createPanel() {
        int i;
        this.setLayout(null);

        JLabel instruction = new JLabel("Please set stressed beat for each 4/4 bar:");
        instruction.setFont(new Font("sans-serif", Font.PLAIN, 20));
        instruction.setLocation(50,20);
        instruction.setSize(400,30);
        this.add(instruction);


        for (i = 1; i <= 4; i++) {
            JLabel label = new JLabel("Bar " + i + ":");
            label.setFont(new Font("sans-serif", Font.PLAIN, 20));
            label.setLocation(50,20 + i * 70);
            label.setSize(100,30);

            JComboBox comboBox = new JComboBox(stressArray);
            comboBox.setLocation(150,20 + i * 70);
            comboBox.setSize(new Dimension(150,30));
            this.putClientProperty("StressBeat" + i, comboBox);

            this.add(label);
            this.add(comboBox);
        }

    }

    private void addComponents() {
        JButton backButton = new JButton("Back");
        backButton.setLocation(50, 370);
        backButton.setSize(new Dimension(100,30));
        backButton.addActionListener(this);

        JButton nextButton = new JButton("Next");
        nextButton.setLocation(300, 370);
        nextButton.setSize(new Dimension(100,30));
        nextButton.addActionListener(this);

        this.add(backButton);
        this.add(nextButton);
    }

    private void processInputs() {
        int i;
        for (i = 1; i <= 4; i++) {
            JComboBox comboBox = (JComboBox) this.getClientProperty("StressBeat" + i);
            stressedBeats.add(Integer.parseInt(stressArray[comboBox.getSelectedIndex()]));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Next")) {
            processInputs();
            GUI.receiveStressPageInputs(name, tempo, genre, stressedBeats);
        } else if (action.equals("Back")) {
            GUI.processAction(GUI.command.get("BACK"));
        }
    }
}
