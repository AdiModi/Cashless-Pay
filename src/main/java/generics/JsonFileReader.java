package generics;

import io.vertx.core.json.JsonObject;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileReader {

    @Getter
    @Setter
    private JsonObject jsonObject;

    public JsonFileReader() {
        jsonObject = null;
    }

    public JsonObject readJson(File file) {

        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        String content = "";
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                content += line;
            }
            jsonObject = new JsonObject(content);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return jsonObject;
        }
    }
}