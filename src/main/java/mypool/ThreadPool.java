package mypool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by sudhirkumar on 5/29/17.
 */
public class ThreadPool{

    private final int threadCount;
    private final BlockingQueue taskQueue;
    private final ThreadPoolWorker threadWorker[];
    private volatile boolean shutdown;

    public ThreadPool(int threadCount) {
        taskQueue = new LinkedBlockingQueue(threadCount);
        this.threadCount = threadCount;
        threadWorker = new ThreadPoolWorker[threadCount];
        for (int i = 0; i < threadWorker.length; i++) {
            threadWorker[i] = new ThreadPoolWorker("ThreadWorker#" + i + "^**");
            threadWorker[i].start();

          //  execute(threadWorker[i]);
        }
    }

    public void execute(Runnable task) throws InterruptedException {
        synchronized (taskQueue) {
            /*boolean isInserted = */taskQueue.put(task);
            System.out.println("Thread ADDing to Queue ...!!" + Thread.currentThread().getId() + " *** Queue Length -- >" + taskQueue.size()
                    /*+ " is Inserted ..." + isInserted*/);
            taskQueue.notify();
        }
    }

    public void shutdown(){
        synchronized (taskQueue) {
            shutdown = true;
        while (!taskQueue.isEmpty()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (ThreadPoolWorker worker: threadWorker) {
            worker.interrupt();
        }
        }
    }



    private class ThreadPoolWorker extends Thread {
        public ThreadPoolWorker(String name) {
            super(name);
        }

        /*@Override
        public synchronized void start() {
            System.out.println("Thread started!!" + Thread.currentThread().getName()+ "-- ???"+Thread.currentThread().getId() + " *** Queue Length -- >" + taskQueue.size());
        }*/

        public void run() {
            Runnable task;
            while (true) {
                try {
                    task = (Runnable) taskQueue.take();
                    System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + " &&&& Queue Length -- >" + taskQueue.size());
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

               /* if (shutdown && taskQueue.size() == 0) {
                    this.interrupt();
                }*/
            }
        }
    }
}
