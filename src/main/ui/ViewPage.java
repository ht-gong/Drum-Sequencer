package ui;

import model.Beat;
import model.BeatCollection;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class ViewPage extends JPanel implements ActionListener {
    BeatCollection myCollection;
    DefaultListModel beats;
    JList jlist;
    JButton playButton;
    JButton deleteButton;

    public ViewPage(BeatCollection myCollection) {
        this.myCollection = myCollection;
        makeList();
        createPanel();
    }

    private void makeList() {
        beats = new DefaultListModel();
        jlist = new JList(beats);

        int length = myCollection.getSize();
        int i;
        for (i = 0; i < length; i++) {
            beats.addElement(myCollection.getBeatAt(i).getName());
        }

        jlist.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                updatePlayButton();
                updateDeleteButton();
            }
        }
        );
    }

    private void updatePlayButton() {
        playButton.setEnabled(true);
    }

    private void updateDeleteButton() {
        deleteButton.setEnabled(true);
    }

    private void createPanel() {
        this.setLayout(null);

        JScrollPane scrollPane = new JScrollPane(jlist);
        scrollPane.setSize(400,200);
        scrollPane.setLocation(30,30);
        this.add(scrollPane);

        JButton backButton = new JButton("Back");
        backButton.setLocation(40, 350);
        backButton.setSize(new Dimension(100,30));
        backButton.addActionListener(this);
        this.add(backButton);

        playButton = new JButton("Play");
        playButton.setLocation(300, 300);
        playButton.setSize(new Dimension(100,30));
        playButton.addActionListener(this);
        this.add(playButton);
        playButton.setEnabled(false);

        deleteButton = new JButton("Delete");
        deleteButton.setLocation(300, 350);
        deleteButton.setSize(new Dimension(100,30));
        deleteButton.addActionListener(this);
        this.add(deleteButton);
        deleteButton.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("Back")) {
            GUI.processAction(GUI.command.get("BACK"));
        } else if (action.equals("Play")) {
            myCollection.playBeatAt(jlist.getSelectedIndex());
        } else if (action.equals("Delete")) {
            myCollection.removeBeatAt(jlist.getSelectedIndex());
            beats.remove(jlist.getSelectedIndex());
            playButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
    }
}
