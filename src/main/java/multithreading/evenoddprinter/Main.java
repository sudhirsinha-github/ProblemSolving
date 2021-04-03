package multithreading.evenoddprinter;

public class Main {
    public static void main(String... args) {
        Printer print = new Printer();
        Thread t3 = new Thread(new Task(false, 10, print), "Odd2");

        Thread t1 = new Thread(new Task(false, 10, print), "Odd1");
        Thread t2 = new Thread(new Task(true, 10, print), "Even");
        t1.start();
        t2.start();
        t3.start();
    }
}
