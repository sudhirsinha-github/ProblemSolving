package threadpool;

/**
 * Created by sudhirkumar on 4/5/17.
 */
public class Task implements Runnable
{

    private int num;

    public Task(int n) {
        num = n;
    }

    public void run() {

        System.out.println("Task " + num + " is running.");
        try {
            Thread.sleep(17021);
            System.out.println("Thread __ sleeping!!!");
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}


class Main {

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(7);

        for (int i = 0; i < 15; i++) {
            Task task = new Task(i);
            pool.execute(task);
        }
    }
}