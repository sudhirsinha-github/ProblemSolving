package threadpool;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool pool = new ThreadPool(3);

        for (int i = 0; i < 12; i++) {
            Task task = new Task(i);
            System.out.printf("--- " + task.getNum());
            pool.execute(task);
        }
    }
}