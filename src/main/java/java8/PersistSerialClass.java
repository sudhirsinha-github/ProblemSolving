package java8;

import java.io.*;
import java.util.Date;

//Class to persist the time in a flat file time.ser
public class PersistSerialClass {

    public static void main(String [] args) {
        String filename = "time.ser";

        if(args.length > 0){
            filename = args[0];
        }

        SerialClass time = new SerialClass();
        FileOutputStream fos = null;
        ObjectOutputStream out = null;

        try{
            fos = new FileOutputStream(filename);
            out = new ObjectOutputStream(fos);
            out.writeObject(time);
            out.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
     }

    public static void mainw(String [] args) {
        String filename = "time.ser";

        if(args.length > 0){
            filename = args[0];
        }

        SerialClass time = null;
        FileInputStream fis = null;
        ObjectInputStream in = null;

        try{
            fis = new FileInputStream(filename);
            in = new ObjectInputStream(fis);
            time = (SerialClass) in.readObject();
            in.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }

        // print out restored time
        System.out.println("Restored time: " + time.getCurrentTime());
        System.out.println("Restored time: " + time.getId());
        System.out.println(new Date());

    }
 }
