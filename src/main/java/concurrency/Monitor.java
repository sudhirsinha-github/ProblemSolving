package concurrency;

public class Monitor implements Runnable{

    Integer variAnInt = 1;

    public void myMethod() {
//        synchronized (variAnInt) {
//            variAnInt++;
//            System.out.println("Inside myMethod: " + variAnInt + ": " +Thread.currentThread().getId());
//        }
        variAnInt++;
        System.out.println("Inside myMethod: " + variAnInt + ": " +Thread.currentThread().getId());
    }

    public void myOtherMethod() {
//        synchronized (variAnInt) {
//            variAnInt++;
//            System.out.println("Inside myOtherMethod: " + variAnInt+ ": " + Thread.currentThread().getId());
//        }
        variAnInt++;
        System.out.println("Inside myOtherMethod: " + variAnInt+ ": " + Thread.currentThread().getId());
    }

    @Override
    public void run() {
        System.out.println("Current Running Thread: "+ Thread.currentThread().getId());
        myMethod();
        myOtherMethod();
    }
}

