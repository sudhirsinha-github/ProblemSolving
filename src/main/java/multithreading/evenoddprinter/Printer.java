package multithreading.evenoddprinter;

public class Printer {
    volatile boolean isEven;
    // print even
    public synchronized void printEven(int number){
        while (isEven)
        {
           try{
               wait();
              // Thread.sleep(2000);
           }
           catch (InterruptedException e)
           {
               System.out.println(e.getMessage());
           }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isEven = true;
        notify();
    }


    // print odd
    public synchronized void printOdd(int number){
        while (!isEven)
        {
            try{
                wait();
              //  Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + number);
        isEven = false;
        notify();
    }
}
