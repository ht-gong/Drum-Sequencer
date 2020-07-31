package model;

import org.jfugue.rhythm.Rhythm;

import java.util.ArrayList;

// Jazz beat model with presets
public class JazzModel extends BeatModel {

    // MODIFIES: this
    // EFFECTS: set genre, give initial tracks to Jazzy beat
    public JazzModel() {
        genre = Beat.JAZZ;
        topLayer = "R.RR..R.RR..";
        snareLayer = "...S.....S..";
        bassLayer = "O..P..O..P..";
        insString = "S";
    }

    // REQUIRES: array of 4 Integers with range from 1-3 that indicates stressed beats
    // EFFECTS: generates a stressed snare line according to the stress input array
    public String createStress(ArrayList<Integer> array) {
        int i;
        String createdRhythm = "";
        for (i = 1; i <= 4; i++) {
            StringBuilder barRhythm = new StringBuilder();
            barRhythm.append(new String(new char[array.get(i - 1) - 1]).replace("\0", "."));
            barRhythm.append(insString);
            barRhythm.append(new String(new char[3 - array.get(i - 1)]).replace("\0", "."));

            if (i % 2 == 0) {
                barRhythm.setCharAt(0, 's');
            }
            createdRhythm += barRhythm.toString();
        }
        return createdRhythm;
    }
}
