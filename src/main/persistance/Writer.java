package persistance;

import com.github.cliftonlabs.json_simple.JsonObject;
import model.Beat;
import model.BeatCollection;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private FileWriter myWriter;

    public Writer(String fileName) throws IOException {
        myWriter = new FileWriter(fileName);
        myWriter.write("[");
    }

    public void writeBeats(BeatCollection collection) throws IOException {
        int i;
        for (i = 0; i < collection.getSize(); i++) {
            writeBeat(collection.getBeatAt(i));
            if (i < collection.getSize() - 1) {
                myWriter.write(", ");
            }
        }

    }

    public void writeBeat(Beat beat) throws IOException {
        JsonObject obj = new JsonObject();
        obj.put("name", beat.getName());
        obj.put("tempo",beat.getTempo());
        obj.put("type",beat.getType());
        obj.put("toplayer",beat.getRhythm().getLayer(0));
        obj.put("snarelayer",beat.getRhythm().getLayer(1));
        obj.put("basslayer",beat.getRhythm().getLayer(2));

        myWriter.write(obj.toJson());

    }

    public void finishWriting() throws IOException {
        myWriter.write("]");
        myWriter.flush();
        myWriter.close();
    }
}
