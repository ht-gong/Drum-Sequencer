package model;

import java.util.ArrayList;

// Electronic beat model with presets
public class ElectroModel extends BeatModel {

    // MODIFIES: this
    // EFFECTS: set genre, give initial tracks to dance-style beat
    public ElectroModel() {
        genre = Beat.ELECTRO;
        topLayer = "^^^^^^^^^^^^^^^^";
        snareLayer = ".Exx..X..EXEXEXE";
        bassLayer = "O...O.o.O.O.O.O.";
        insString = "E";
    }

    // REQUIRES: array of 4 Integers all from 1-4 that indicates stressed beats
    // EFFECTS: generates a stressed snare line according to the stress input array
    public String createStress(ArrayList<Integer> array) {
        int i;
        String createdRhythm = "";
        for (i = 1; i <= 3; i++) {
            StringBuilder barRhythm = new StringBuilder();
            barRhythm.append(new String(new char[array.get(i - 1) - 1]).replace("\0", "."));
            barRhythm.append(insString);
            barRhythm.append(new String(new char[4 - array.get(i - 1)]).replace("\0", "."));
            createdRhythm += barRhythm.toString();
        }
        createdRhythm += "EXEX";
        return createdRhythm;
    }
}
