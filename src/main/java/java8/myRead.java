package java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class myRead implements CustomRead{
    @Override
    public boolean read(){
        return CustomRead.super.read();
    }


    //checked exception
    public void read(String filePath) {
        try{
            Files.readAllLines(Paths.get(filePath));
        }catch(IOException iox){
            iox.printStackTrace();
        }
    }

    //unchecked exception -NPE
    public void divide(int num1, int num2) {
        try{
            int result = num1/num2;
        }catch(Exception ex){
            throw new RuntimeException("Divide by zero");
        }

    }
}

