package persistance;

import com.github.cliftonlabs.json_simple.JsonException;
import model.BeatCollection;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest {
    private Reader reader;
    private BeatCollection testcollection;

    @Test
    void TestReadBeatFile1() {
        try {
            reader = new Reader("./data/testReader1.json");
            testcollection = reader.readFile();

            assertEquals(1, testcollection.getSize());
            assertEquals("reading", testcollection.getBeatAt(0).getName());
            assertEquals("HIPHOP", testcollection.getBeatAt(0).getType());
            assertEquals(210, testcollection.getBeatAt(0).getTempo());
            assertEquals("```+`````+``",
                    testcollection.getBeatAt(0).getRhythm().getLayer(0)
            );
            assertEquals("S..Ss.S..Ss.",
                    testcollection.getBeatAt(0).getRhythm().getLayer(1)
            );
            assertEquals("O.o...Oo.oO.", testcollection.getBeatAt(0).getRhythm().getLayer(2)
            );

        } catch (Exception e) {
            e.printStackTrace();
            fail("Should not have thrown Exception");
        }
    }

    @Test
    void testIOException() {
        try {
            reader = new Reader("./data/does/not/exist/test.json");
            testcollection = reader.readFile();
        } catch (IOException e) {
            // expected
        } catch (JsonException e) {
            fail("Should not have caught JsonException");
        }
    }

    @Test
    void testJsonException() {
        try {
            reader = new Reader("./data/testBadJson.json");
            testcollection = reader.readFile();
        } catch (JsonException e) {
            // expected
        } catch (IOException e) {
            fail("Should not have caught IOException");
        }
    }
}
