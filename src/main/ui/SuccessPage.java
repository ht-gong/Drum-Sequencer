package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuccessPage extends JPanel implements ActionListener {

    public SuccessPage() {
        createPanel();
    }

    private void createPanel() {
        this.setLayout(null);

        ImageIcon pic = new ImageIcon("./data/img/CheckMark.png");
        JLabel image = new JLabel(pic);
        image.setSize(new Dimension(250,250));
        image.setLocation(120,20);
        this.add(image);

        JLabel instruction = new JLabel("Beat Created!");
        instruction.setFont(new Font("sans-serif", Font.PLAIN, 25));
        instruction.setLocation(150,300);
        instruction.setSize(400,50);
        this.add(instruction);

        JButton backButton = new JButton("Back");
        backButton.setLocation(190, 380);
        backButton.setSize(new Dimension(100,30));
        backButton.addActionListener(this);
        this.add(backButton);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Back")) {
            GUI.processAction(GUI.command.get("BACK"));
        }
    }
}
