package multithreading.evenoddprinter;

public class Task implements Runnable {
    boolean isEven;
    int max;
    Printer printer;

    public Task(boolean isEven, int max, Printer printer) {
        this.isEven = isEven;
        this.max = max;
        this.printer = printer;
    }

    @Override
    public void run() {
        int starter = isEven ? 2 : 1;

        for (int i = starter; i < max; i = i + 2) {
            if (isEven)
                this.printer.printEven(i);
            else
                this.printer.printOdd(i);
        }
    }
}

