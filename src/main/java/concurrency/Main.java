package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        AtomicInteger integer;
        Monitor monitor = new Monitor();
        try{
            for(int i = 0 ; i < 3 ;i++){
                executor.execute(monitor);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
