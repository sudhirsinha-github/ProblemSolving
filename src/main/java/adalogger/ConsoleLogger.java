package adalogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConsoleLogger extends AbstractLogger{
   ConsoleLogger(int level)
   {
      this.level = level;
   }

   @Override
   protected void write(String message) {
      System.out.println("Logging to console -- " + message);
   }
}

class FileLogger extends AbstractLogger{
   final static File file = new File("fileA.txt");
   static FileWriter fileWriter = null;
   static BufferedWriter bufferedWriter = null;

   FileLogger(int level)
   {
      this.level = level;
   }

   static {
      try {
         fileWriter = new FileWriter(file,true);
         bufferedWriter = new BufferedWriter(fileWriter, 1222);
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   @Override
   public void write(String message) {
      // write to a File
      try {
         bufferedWriter.write(message);
         bufferedWriter.newLine();
         System.out.printf("Writing to file -- " +message);
         bufferedWriter.flush();

      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}

