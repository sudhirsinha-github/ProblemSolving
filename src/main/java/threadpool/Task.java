package threadpool;

public class Task<T> implements Runnable {

    private volatile int num;

    public Task(int n) {
        num = n;
    }

    public int getNum()
    {
        return num;
    }

    public void run() {
        System.out.println("\n \n Task " + num + " is running on thread - " + Thread.currentThread().getId());
    }
}