package venkat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LineCount {

    public static void main(String[] args){
        System.out.println(countLine("position"));
    }


    public static long countLine(String searchWord) {
        Stream<String> lines;
        try {
             lines = Files.lines(Paths.get("src/main/java/venkat/MyFirst.java"));

                        return lines
                    .filter(line ->{
                        System.out.println("In lines");
                        return line.contains(searchWord);})
                    .mapToLong(line -> line.split(searchWord).length - 1)
                    .sum();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return -1;
    }
}
