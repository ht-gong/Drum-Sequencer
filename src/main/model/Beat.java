package model;


import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// A beat that has attributes and includes the rhythm
public class Beat {
    public static final String ROCK = "ROCK";
    public static final String ELECTRO = "ELECTRONIC";
    public static final String JAZZ = "JAZZ";
    public static final String HIPHOP = "HIPHOP";

    private Rhythm myRhythm;
    private BeatModel myModel;
    private Integer tempo;
    private String type;
    private ArrayList<Integer> stressBeats;
    private String name;

    // This is an abbreviation map from a char to specific instruments in the library.
    Map<Character, String> myRhythmKit = new HashMap<Character, String>() {
        {
            this.put('.', "Ri");
            this.put('O', "[BASS_DRUM]i");
            this.put('o', "Rs [BASS_DRUM]s");
            this.put('S', "[ACOUSTIC_SNARE]i");
            this.put('E', "[ELECTRIC_SNARE]i");
            this.put('s', "Rs [ACOUSTIC_SNARE]s");
            this.put('^', "[CLOSED_HI_HAT]i");
            this.put('`', "[CLOSED_HI_HAT]s Rs");
            this.put('*', "[CRASH_CYMBAL_1]i");
            this.put('+', "[CRASH_CYMBAL_1]s Rs");
            this.put('X', "[HAND_CLAP]i");
            this.put('x', "Rs [HAND_CLAP]s");
            this.put(' ', "Ri");
            this.put('R', "[RIDE_CYMBAL_1]i");
            this.put('P', "[PEDAL_HI_HAT]");
        }
    };

    // MODIFIES: this
    // EFFECTS: Create empty beat.
    public Beat() {
        type = null;
        tempo = null;
        myRhythm = new Rhythm();
        myRhythm.setRhythmKit(myRhythmKit);
        stressBeats = null;
    }

    // REQUIRES: 1 of 4 preset genres, the tempo for the beat, stressed beats (4 Integers, 1-3 for Jazz & HipHop;
    // 1-4 for Rock & Dance music
    // MODIFIES: this
    // EFFECTS: Create beat with given tempo, genre, and stressed beats

    public Beat(String type, Integer tempo, ArrayList<Integer> stressBeats) {
        this.type = type;
        this.tempo = tempo;
        this.stressBeats = stressBeats;
        myRhythm = new Rhythm();
        myRhythm.setRhythmKit(myRhythmKit);
        if (this.type.equals(JAZZ)) {
            myModel = new JazzModel();
        } else if (this.type.equals(ROCK)) {
            myModel = new RockModel();
        } else if (this.type.equals(ELECTRO)) {
            myModel = new ElectroModel();
        } else {
            myModel = new HipHopModel();
        }
        myRhythm
                .addLayer(myModel.getTopLayer())
                .addLayer(myModel.createStress(stressBeats))
                .addLayer(myModel.getBassLayer());

    }

    // REQUIRES: 1 of 4 preset genres, the tempo for the beat
    // MODIFIES: this
    // EFFECTS: makes beat according template without stressed beats
    public Beat(String type, Integer tempo) {
        this.type = type;
        this.tempo = tempo;
        myRhythm = new Rhythm();
        myRhythm.setRhythmKit(myRhythmKit);
        if (this.type.equals(JAZZ)) {
            myModel = new JazzModel();
        } else if (this.type.equals(ROCK)) {
            myModel = new RockModel();
        } else if (this.type.equals(ELECTRO)) {
            myModel = new ElectroModel();
        } else {
            myModel = new HipHopModel();
        }
        myRhythm
                .addLayer(myModel.getTopLayer())
                .addLayer(myModel.getSnareLayer())
                .addLayer(myModel.getBassLayer());
    }

    // EFFECTS: gets rhythm
    public Rhythm getRhythm() {
        return myRhythm;
    }

    // EFFECTS: gets type (genre)
    public String getType() {
        return type;
    }

    // EFFECTS: gets tempo
    public Integer getTempo() {
        return tempo;
    }

    // EFFECTS: gets name
    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: sets name
    public void setName(String name) {
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: sets tempo
    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    // MODIFIES: this
    // EFFECTS: sets type
    public void setType(String type) {
        this.type = type;
    }

    // MODIFIES: this
    // EFFECTS: sets new layer

    public void setNewLayer(String newLayer) {
        myRhythm.addLayer(newLayer);
    }
}
