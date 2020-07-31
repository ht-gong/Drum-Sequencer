package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class HomePage extends JPanel implements ActionListener {

    public HomePage() {
        createPanel();
    }

    private void createPanel() {
        JPanel paneltop = new JPanel();
        LayoutManager layout = new FlowLayout();
        paneltop.setLayout(layout);
        paneltop.setOpaque(false);

        JLabel title = new JLabel("Beat Maker");
        title.setFont(new Font("sans-serif", Font.PLAIN, 30));
        paneltop.add(title);

        JPanel panelmid = new JPanel();
        ImageIcon pic = new ImageIcon("./data/img/DrumSet.png");
        JLabel image = new JLabel(pic);
        image.setPreferredSize(new Dimension(250,200));
        panelmid.add(image);
        panelmid.setOpaque(false);

        JPanel panelbot = new JPanel();
        createButtons(panelbot);

        LayoutManager layout3 = new BorderLayout();
        this.setLayout(layout3);
        this.add(paneltop, BorderLayout.PAGE_START);
        this.add(panelmid, BorderLayout.CENTER);
        this.add(panelbot, BorderLayout.PAGE_END);
        this.setOpaque(false);
    }

    private void createButtons(JPanel panelBot) {
        LayoutManager layout2 = new BoxLayout(panelBot, BoxLayout.PAGE_AXIS);
        panelBot.setLayout(layout2);

        JButton viewButton = new JButton("View Beats");
        viewButton.setPreferredSize(new Dimension(100,30));
        viewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewButton.addActionListener(this);

        JButton createButton = new JButton("Create Beat");
        createButton.setPreferredSize(new Dimension(100,30));
        createButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        createButton.addActionListener(this);

        JButton quitButton = new JButton("Quit");
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.setPreferredSize(new Dimension(100,30));
        quitButton.addActionListener(this);

        panelBot.add(viewButton);
        panelBot.add(Box.createVerticalStrut(10));
        panelBot.add(createButton);
        panelBot.add(Box.createVerticalStrut(10));
        panelBot.add(quitButton);
        panelBot.add(Box.createVerticalStrut(15));
        panelBot.add(Box.createVerticalGlue());
        panelBot.setOpaque(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("View Beats")) {
            GUI.processAction(GUI.command.get("VIEW"));
        }  else if (action.equals("Create Beat")) {
            GUI.processAction(GUI.command.get("CREATE"));
        }  else if (action.equals("Quit")) {
            GUI.processAction(GUI.command.get("QUIT"));
        }
    }
}
