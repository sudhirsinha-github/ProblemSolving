package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class ReadFile {

    public final static String fileName = "src/main/java/stream/SampleCSVFile_2kb.csv";
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Process process = new Process();

        try{
            for(int i =0 ; i < 2 ;i++){
                executor.execute(process);
            }
        }catch(Exception ex){

        }
    }

    static class Process implements Runnable {
        public void readAsStream() {
            long date = System.currentTimeMillis();

            try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
                System.out.println(lines.count());
            } catch (IOException e) {
                e.printStackTrace();
            }
            long end = System.currentTimeMillis();
            System.out.println(end - date);
        }

        public void readAsList() {
            long date2 = System.currentTimeMillis();
            try {
                List<String> lines = Files.readAllLines(Paths.get(fileName));
                System.out.println(lines.size());
            } catch (IOException e) {
                e.printStackTrace();
            }
            long end2 = System.currentTimeMillis();
            System.out.println(end2 - date2);
        }

        @Override
        public void run() {
            readAsStream();
        }
    }
}
