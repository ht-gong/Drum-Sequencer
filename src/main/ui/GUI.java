package ui;

import model.Beat;
import model.BeatCollection;
import persistance.Reader;
import persistance.Writer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Main GUI, starting point for project
public class GUI {

    private static MyFrame myFrame;
    private static CreateStressPage createStressPage;
    private static CreatePage createPage;
    private static SuccessPage successPage;
    private static HomePage homePage;
    private static ViewPage viewPage;

    private static BeatCollection myCollection;
    private static Writer writer;
    private Reader reader;

    private static final String beatFile = "./data/beatFile.json";

    public static final Map<String, String> command = new HashMap<String, String>() {
        {
            put("BACK", "back");
            put("CREATE", "create");
            put("VIEW", "view");
            put("QUIT", "quit");
        }
    };


    // MODIFIES: this
    // EFFECTS: Initializes GUI
    public GUI() {
        myCollection = new BeatCollection();

        readBeats();
        initializeWriter();

        homePage = new HomePage();
        successPage = new SuccessPage();
        myFrame = new MyFrame(homePage);

    }

    // MODIFIES: this
    // EFFECTS: Receives inputs from the Create Page
    public static void receiveCreatePageInputs(String name, int tempo, String genre, Boolean stress) {
        Beat newBeat;
        if (stress) {
            createStressPage = new CreateStressPage(name, tempo, genre);
            myFrame.changePanel(createStressPage);
        } else {
            newBeat = new Beat(genre, tempo);
            newBeat.setName(name);
            myCollection.addBeat(newBeat);
            showSuccess();
        }
    }

    // MODIFIES: this
    // EFFECTS: Receives inputs from the Create Stress Page
    public static void receiveStressPageInputs(String name, int tempo, String genre, ArrayList<Integer> stressArray) {
        Beat newBeat;
        newBeat = new Beat(genre, tempo,stressArray);
        newBeat.setName(name);
        myCollection.addBeat(newBeat);
        showSuccess();
    }


    private static void showSuccess() {
        myFrame.changePanel(successPage);
    }

    public static void showDialog(String display) {
        myFrame.showDialog(display);
    }

    public static void processAction(String action) {
        if (action.equals(command.get("VIEW"))) {
            viewPage = new ViewPage(myCollection);
            myFrame.changePanel(viewPage);
        }  else if (action.equals(command.get("CREATE"))) {
            createPage = new CreatePage();
            myFrame.changePanel(createPage);
        }  else if (action.equals(command.get("QUIT"))) {
            writeBeats();
            myFrame.closeWindow();
        }  else if (action.equals(command.get("BACK"))) {
            myFrame.changeToHomePanel(homePage);
        }
    }

    private void readBeats() {
        try {
            reader = new Reader(beatFile);
            myCollection = reader.readFile();
        } catch (Exception e) {
            showDialog(e.toString());
        }
    }

    private void initializeWriter() {
        try {
            writer = new Writer(beatFile);
        } catch (Exception e) {
            showDialog(e.toString());
        }
    }

    private static void writeBeats() {
        try {
            writer.writeBeats(myCollection);
            writer.finishWriting();
        } catch (IOException e) {
            showDialog(e.toString());
        }
    }
}
