package model;

import java.util.ArrayList;
import org.jfugue.player.Player;

// A collection of beats which has the function to add beats and play beats
public class BeatCollection {
    private ArrayList<Beat> myBeats;
    private int size;
    public Player rhythmPlayer;

    // EFFECTS: initializes a collection of beats
    public BeatCollection() {
        size = 0;
        myBeats = new ArrayList<>();
        rhythmPlayer = new Player();
    }

    // MODIFIES: this
    // EFFECTS: adds a new beat to the collection
    public void addBeat(Beat beat) {
        myBeats.add(beat);
        size++;
    }

    // EFFECTS: lists the titles of the beats
    public String listTitles() {
        String str;
        int i;

        str = "";

        for (i = 0; i < size; i++) {
            str += myBeats.get(i).getName() + "\n";
        }
        return str;
    }

    // REQUIRES: index to be valid and inside bounds
    // EFFECTS: returns beat at that specific index
    public Beat getBeatAt(int index) {
        return myBeats.get(index);
    }

    // REQUIRES: index to be valid and inside bounds
    // EFFECTS: plays beat at that specific index with indicated tempo
    public Boolean playBeatAt(int index) {
        String tempo;
        tempo = "T" + myBeats.get(index).getTempo().toString() + " ";

        rhythmPlayer.play(tempo + myBeats.get(index).getRhythm().getPattern().repeat(3));
        return true;
    }

    public void removeBeatAt(int index) {
        myBeats.remove(index);
        size--;
    }

    // EFFECTS: returns collection size
    public int getSize() {
        return size;
    }

}
