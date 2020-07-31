package model;

import java.util.ArrayList;

// Rock beat model with presets
public class RockModel extends BeatModel {


    // MODIFIES: this
    // EFFECTS: set genre, give initial tracks to rock-styled beat
    public RockModel() {
        genre = Beat.ROCK;
        topLayer = "````+````````+```";
        snareLayer = "..S...S...S...S.";
        bassLayer = "O.ooO...O.ooO...";
        insString = "S";
    }

    // REQUIRES: array of 4 Integers all from 1-4 that indicates stressed beats
    // EFFECTS: generates a stressed snare line according to the stress input array
    public String createStress(ArrayList<Integer> array) {
        int i;
        String createdRhythm = "";
        for (i = 1; i <= 4; i++) {
            StringBuilder barRhythm = new StringBuilder();
            barRhythm.append(new String(new char[array.get(i - 1) - 1]).replace("\0", "."));
            barRhythm.append(insString);
            barRhythm.append(new String(new char[4 - array.get(i - 1)]).replace("\0", "."));

            if (i % 2 == 0) {
                barRhythm.setCharAt(1, 's');
            }
            createdRhythm += barRhythm.toString();
        }
        return createdRhythm;
    }


}
