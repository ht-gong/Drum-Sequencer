package persistance;

import model.Beat;
import model.BeatCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WriterTest {
    private static final String TEST_FILE = "./data/testbeats.json";
    private Writer writer;
    private Reader reader;
    private BeatCollection testCollection;
    private BeatCollection testReadCollection;

    @BeforeEach
    void runBefore() throws IOException {
        writer = new Writer(TEST_FILE);
        reader = new Reader(TEST_FILE);
        testCollection = new BeatCollection();

        Beat beat = new Beat("HIPHOP", 120);
        beat.setName("Test1");
        testCollection.addBeat(beat);
        beat = new Beat("JAZZ", 100, new ArrayList<Integer>(){
            {
                add(2);
                add(2);
                add(3);
                add(3);
            }});
        beat.setName("Test2");

        testCollection.addBeat(beat);
    }

    @Test
    void testWriteBeats() {

        try {
            writer.writeBeats(testCollection);
            writer.finishWriting();

            testReadCollection = reader.readFile();

            assertEquals(2, testReadCollection.getSize());
            assertEquals(120, testReadCollection.getBeatAt(0).getTempo());
            assertEquals("HIPHOP", testReadCollection.getBeatAt(0).getType());
            assertEquals("Test1", testReadCollection.getBeatAt(0).getName());
            assertEquals("```+`````+``", testReadCollection.getBeatAt(0).getRhythm().getLayer(0));
            assertEquals("S..Ss.S..Ss.", testReadCollection.getBeatAt(0).getRhythm().getLayer(1));
            assertEquals("O.o...Oo.oO.", testReadCollection.getBeatAt(0).getRhythm().getLayer(2));

            assertEquals(100,testReadCollection.getBeatAt(1).getTempo());
            assertEquals("JAZZ",testReadCollection.getBeatAt(1).getType());
            assertEquals("Test2",testReadCollection.getBeatAt(1).getName());
            assertEquals("R.RR..R.RR..", testReadCollection.getBeatAt(1).getRhythm().getLayer(0));
            assertEquals(".S.sS...Ss.S", testReadCollection.getBeatAt(1).getRhythm().getLayer(1));
            assertEquals("O..P..O..P..", testReadCollection.getBeatAt(1).getRhythm().getLayer(2));

        } catch (Exception e) {
            e.printStackTrace();
            fail("IOException should not have been thrown");
        }

    }
}
