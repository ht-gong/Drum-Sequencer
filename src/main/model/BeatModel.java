package model;

import org.jfugue.rhythm.Rhythm;

import java.util.ArrayList;

// An abstract model of the 4 types of beats available, include methods for getting layers for rhythm
public abstract class BeatModel {
    protected String genre;
    protected String topLayer;
    protected String snareLayer;
    protected String bassLayer;
    protected String insString;

    // EFFECTS: returns preset top layer
    public String getTopLayer() {
        return topLayer;
    }

    // EFFECTS: returns preset snare layer
    public String getSnareLayer() {
        return snareLayer;
    }

    // EFFECTS: returns preset bass layer
    public String getBassLayer() {
        return bassLayer;
    }

    // EFFECTS: returns genre
    public String getGenre() {
        return genre;
    }

    abstract String createStress(ArrayList<Integer> array);
}
