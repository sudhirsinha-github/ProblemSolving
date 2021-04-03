package soundex;


import org.json.simple.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class NickNameChecker {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        String url = "src/main/java/soundex/name.json";
        Stream<String> lines = Files.lines(Paths.get(url));
        JSONArray jsonArray = new JSONArray();

        lines.
               forEach(t-> System.out.println(t));
    }
}
