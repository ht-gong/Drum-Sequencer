package model;

import org.jfugue.rhythm.Rhythm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BeatCollectionTest {
    private BeatCollection myCollection;
    private Rhythm testRhythm;

    @BeforeEach
    void runBefore() {
        testRhythm = new Rhythm().addLayer("R.RR..R.RR..").addLayer(".S.sS...Ss.S").addLayer("O..P..O..P..");
        myCollection = new BeatCollection();
    }

    @Test
    void testConstructor(){
        myCollection = new BeatCollection();
        assertEquals(0, myCollection.getSize());


    }
    @Test
    void testPlay(){
        myCollection.addBeat(new Beat("JAZZ", 110, new ArrayList<Integer>(){
            {
                add(2);
                add(2);
                add(3);
                add(3);
            }}));
        assertTrue(myCollection.playBeatAt(0));

    }

    @Test
    void testAddBeat() {
        myCollection.addBeat(new Beat("JAZZ", 110, new ArrayList<Integer>(){
            {
                add(2);
                add(2);
                add(3);
                add(3);
            }}));
        myCollection.addBeat(new Beat("ROCK", 210, new ArrayList<Integer>(){
            {
                add(2);
                add(2);
                add(3);
                add(3);
            }}));
        assertEquals(2, myCollection.getSize());
        assertEquals(myCollection.getBeatAt(0).getRhythm().getLayer(0),
                testRhythm.getLayer(0)
                );
        assertEquals(myCollection.getBeatAt(0).getRhythm().getLayer(1),
                testRhythm.getLayer(1)
        );
        assertEquals(myCollection.getBeatAt(0).getRhythm().getLayer(2),
                testRhythm.getLayer(2)
        );
    }

    @Test
    void testRemoveBeat() {
        myCollection.addBeat(new Beat("JAZZ", 110, new ArrayList<Integer>(){
            {
                add(2);
                add(2);
                add(3);
                add(3);
            }}));
        myCollection.addBeat(new Beat("ROCK", 210, new ArrayList<Integer>(){
            {
                add(2);
                add(2);
                add(3);
                add(3);
            }}));
        myCollection.removeBeatAt(1);
        assertEquals(1, myCollection.getSize());
        assertEquals(myCollection.getBeatAt(0).getRhythm().getLayer(0),
                testRhythm.getLayer(0)
        );
        assertEquals(myCollection.getBeatAt(0).getRhythm().getLayer(1),
                testRhythm.getLayer(1)
        );
        assertEquals(myCollection.getBeatAt(0).getRhythm().getLayer(2),
                testRhythm.getLayer(2)
        );
    }

    @Test
    void testListName() {
        Beat b1 = new Beat("JAZZ", 110, new ArrayList<Integer>(){
            {
                add(2);
                add(2);
                add(3);
                add(3);
            }});
        Beat b2 = new Beat("ROCK", 210, new ArrayList<Integer>(){
            {
                add(2);
                add(2);
                add(3);
                add(3);
            }});
        b1.setName("Jazzy");
        b2.setName("Rocky");
        myCollection.addBeat(b1);
        myCollection.addBeat(b2);

        assertEquals("Jazzy\nRocky\n", myCollection.listTitles());
    }
}

