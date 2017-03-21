package concurrency;

/**
 * Created by sudhirkumar on 3/20/17.
 */
public class ThreadWorker {

}

class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Started running MyThread");
    }
}


class MyThread2 extends Thread{

}