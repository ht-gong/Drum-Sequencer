package model;

import org.jfugue.player.Player;
import org.jfugue.rhythm.Rhythm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BeatTest {
    private Beat testBeat;

    @BeforeEach
    void RunBefore(){}

    @Test
    void TestConstructorNoArg() {
        testBeat = new Beat();

        assertNull(testBeat.getTempo());
        assertNull(testBeat.getType());
        assertNull(testBeat.getName());
    }

    @Test
    void TestConstructor2argJazz(){
        testBeat = new Beat("JAZZ", 120);
        assertEquals(120, testBeat.getTempo());
        assertEquals("JAZZ", testBeat.getType());
        assertEquals("R.RR..R.RR..",
                testBeat.getRhythm().getLayer(0));
        assertEquals("...S.....S..",
                    testBeat.getRhythm().getLayer(1));
        assertEquals("O..P..O..P..",
                testBeat.getRhythm().getLayer(2));
    }

    @Test
    void TestConstructor2argRock(){
        testBeat = new Beat("ROCK", 120);
        assertEquals(120, testBeat.getTempo());
        assertEquals("ROCK", testBeat.getType());
        assertEquals("````+````````+```",
                testBeat.getRhythm().getLayer(0));
        assertEquals("..S...S...S...S.",
                testBeat.getRhythm().getLayer(1));
        assertEquals("O.ooO...O.ooO...",
                testBeat.getRhythm().getLayer(2));
    }

    @Test
    void TestConstructor2argElectro() {
        testBeat = new Beat("ELECTRONIC", 120);
        assertEquals(120, testBeat.getTempo());
        assertEquals("ELECTRONIC", testBeat.getType());
        assertEquals("^^^^^^^^^^^^^^^^",
                testBeat.getRhythm().getLayer(0));
        assertEquals(".Exx..X..EXEXEXE",
                testBeat.getRhythm().getLayer(1));
        assertEquals("O...O.o.O.O.O.O.",
                testBeat.getRhythm().getLayer(2));
    }

    @Test
    void TestConstructor2argHipHop() {
        testBeat = new Beat("HIPHOP", 120);
        assertEquals(120, testBeat.getTempo());
        assertEquals("HIPHOP", testBeat.getType());
        assertEquals("```+`````+``",
                testBeat.getRhythm().getLayer(0));
        assertEquals("S..Ss.S..Ss.",
                testBeat.getRhythm().getLayer(1));
        assertEquals("O.o...Oo.oO.",
                testBeat.getRhythm().getLayer(2));
    }

    @Test
    void TestConstructor3argJazz(){
        testBeat = new Beat("JAZZ", 120, new ArrayList<Integer>(){
            {
                add(2);
                add(2);
                add(3);
                add(3);
            }});
        assertEquals(120, testBeat.getTempo());
        assertEquals("JAZZ", testBeat.getType());
        assertEquals("R.RR..R.RR..",
                testBeat.getRhythm().getLayer(0));
        assertEquals(".S.sS...Ss.S",
                testBeat.getRhythm().getLayer(1));
        assertEquals("O..P..O..P..",
                testBeat.getRhythm().getLayer(2));
    }

    @Test
    void TestConstructor3argHipHop(){
        testBeat = new Beat("HIPHOP", 120, new ArrayList<Integer>(){
            {
                add(2);
                add(2);
                add(3);
                add(1);
            }});
        assertEquals(120, testBeat.getTempo());
        assertEquals("HIPHOP", testBeat.getType());
        assertEquals("```+`````+``",
                testBeat.getRhythm().getLayer(0));
        assertEquals(".s..S...ssS.",
                testBeat.getRhythm().getLayer(1));
        assertEquals("O.o...Oo.oO.",
                testBeat.getRhythm().getLayer(2));
    }


    @Test
    void TestConstructor3argElectro(){
        testBeat = new Beat("ELECTRONIC", 120, new ArrayList<Integer>(){
            {
                add(1);
                add(4);
                add(2);
                add(1);
            }});
        assertEquals(120, testBeat.getTempo());
        assertEquals("ELECTRONIC", testBeat.getType());
        assertEquals("^^^^^^^^^^^^^^^^",
                testBeat.getRhythm().getLayer(0));
        assertEquals("E......E.E..EXEX",
                testBeat.getRhythm().getLayer(1));
        assertEquals("O...O.o.O.O.O.O.",
                testBeat.getRhythm().getLayer(2));
    }

    @Test
    void TestConstructor3argRock(){
        testBeat = new Beat("ROCK", 120, new ArrayList<Integer>(){
            {
                add(1);
                add(4);
                add(2);
                add(1);
            }});
        assertEquals(120, testBeat.getTempo());
        assertEquals("ROCK", testBeat.getType());
        assertEquals("````+````````+```",
                testBeat.getRhythm().getLayer(0));
        assertEquals("S....s.S.S..Ss..",
                testBeat.getRhythm().getLayer(1));
        assertEquals("O.ooO...O.ooO...",
                testBeat.getRhythm().getLayer(2));
    }

    @Test
    void TestSetName(){
        testBeat = new Beat("ROCK", 120);
        testBeat.setName("ROCK I");
        assertEquals("ROCK I", testBeat.getName());
    }

    @Test
    void TestSetTempo() {
        testBeat = new Beat("ROCK", 120);
        testBeat.setTempo(210);
        assertEquals(210, testBeat.getTempo());
    }

    @Test
    void TestSetType() {
        testBeat = new Beat("ROCK", 120);
        testBeat.setType("JAZZ");
        assertEquals("JAZZ",testBeat.getType());
    }

    @Test
    void TestSetNewLayer() {
        testBeat = new Beat("ROCK", 120);
        testBeat.setNewLayer("SSSSSSSSSSSSS");
        assertEquals("SSSSSSSSSSSSS",testBeat.getRhythm().getLayer(3));
    }
}
