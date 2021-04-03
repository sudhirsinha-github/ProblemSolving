package ceclogger;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class ConsoleLogger extends AbstractLogger{

    @Override
    public void logMessage(Level level, String log) {
        if(level == Level.INFO)
        this.info(log);
    }
}

class FileLogger extends AbstractLogger {
    final static File file = new File("file.txt");
    static FileWriter fileWriter = null;
    static BufferedWriter bufferedWriter = null;

    static {
        try {
            fileWriter = new FileWriter(file,true);
            bufferedWriter = new BufferedWriter(fileWriter, 1222);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void logMessage(Level level, String log) {

        try {
/*


            if (level == Level.Error)
                this.LogError(log, new RuntimeException("test"));
*/
            bufferedWriter.write(log);
            bufferedWriter.newLine();
            System.out.printf("Writing to file");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void close()
    {
       if(bufferedWriter != null)
           try {
               bufferedWriter.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
    }
}