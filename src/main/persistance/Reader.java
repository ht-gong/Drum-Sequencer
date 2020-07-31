package persistance;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;
import model.Beat;
import model.BeatCollection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    private FileReader reader;
    private BeatCollection collection;
    JsonArray readArray;

    public Reader(String fileName) throws IOException {
        reader = new FileReader(fileName);
        collection = new BeatCollection();
    }

    public BeatCollection readFile() throws IOException, JsonException {

        String line = null;

        BufferedReader buffReader = new BufferedReader(reader);

        while ((line = buffReader.readLine()) != null) {
            readArray = (JsonArray) Jsoner.deserialize(line);
            for (int i = 0; i < readArray.size(); i++) {
                collection.addBeat(readBeat((JsonObject) readArray.get(i)));
            }
        }

        buffReader.close();
        return collection;
    }

    public Beat readBeat(JsonObject obj) {
        Beat b = new Beat();
        b.setName(obj.get("name").toString());
        b.setTempo(Integer.parseInt(obj.get("tempo").toString()));
        b.setType(obj.get("type").toString());

        b.setNewLayer(obj.get("toplayer").toString());
        b.setNewLayer(obj.get("snarelayer").toString());
        b.setNewLayer(obj.get("basslayer").toString());

        return b;
    }
}
