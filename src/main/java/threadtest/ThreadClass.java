package threadtest;

public class ThreadClass {
    //public volatile static ArrayList<Integer> array = new ArrayList<>();

    public static void main(String[] args) {

        Printer printer = new Printer();
        int MAX_1 = 1200;
     Thread thread = new Thread(new A(printer,MAX_1));
     thread.start();

     Thread thread2 = new Thread(new B(printer,MAX_1));
     thread2.start();

    }
}

class Printer{

    boolean isEven = true;
     void printOdd(int i) throws InterruptedException {
        synchronized (this) {
            if (!isEven)
                wait();

            System.out.println(i + "--" + Thread.currentThread().getId());

            isEven = false;
            notify();
        }
    }

    void printEven(int i) throws InterruptedException {
        synchronized (this) {
            if (isEven)
                wait();

            System.out.println(i + "--" + Thread.currentThread().getId());
            isEven = true;
            notify();
        }
    }

}
class A implements Runnable{
    Printer printer;
    int Max;

    public A(Printer printer, int max) {
        this.printer = printer;
        Max = max;
    }

    @Override
    public void run() {
        for (int i = 2; i < Max; i+=2) {
            //System.out.println("Thread "+ Thread.currentThread().getId() + " is running .. ");

            //print Even
            try {
                printer.printEven(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class B implements Runnable{
    Printer printer;
    int Max;

    public B(Printer printer, int max) {
        this.printer = printer;
        Max = max;
    }

    @Override
    public void run() {
        for (int i = 1; i < Max; i+=2) {
            //System.out.println("Thread "+ Thread.currentThread().getId() + " is running .. ");

            // Print ODD
            try {
                printer.printOdd(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}