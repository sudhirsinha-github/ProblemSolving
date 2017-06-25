package mypool;

public class Task implements Runnable {

    private int num;

    public Task(int n) {
        num = n;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task " + num + " is running.");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool(5);

        for (int i = 1; i < 5; i++) {
            Task task = new Task(i);
            pool.execute(task);
        }

        //pool.shutdown();
        Thread.sleep(888);
        for (int i = 80; i < 85; i++) {
            Task task = new Task(i);
            pool.execute(task);
        }
    }
}