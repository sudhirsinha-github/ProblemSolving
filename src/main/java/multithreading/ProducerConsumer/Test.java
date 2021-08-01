package multithreading.ProducerConsumer;


import gherkin.lexer.Th;

import java.util.*;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();

        Thread producer = new Thread(
                () -> {
                    try {
                        producerConsumer.produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        Thread consumer = new Thread(
                () -> {
                    try {
                        producerConsumer.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        );

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }

}

class ProducerConsumer {
    List integerList = new LinkedList<Integer>();
    int capacity = 2; //size
    volatile int data = 0;

    public void produce() throws InterruptedException {
        while (true) {

            synchronized (this) {
                if (this.integerList.size() == capacity) {
                    System.out.println("waiting ...");
                    wait();
                }

                System.out.println("Producer produces -->" + data);
                integerList.add(data++);

                notify();

                Thread.sleep(1000);
            }
        }

    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                if (integerList.isEmpty())
                {
                    System.out.println("waiting ...");
                    wait();
                }


                System.out.println(" Consumer consumes -->> " + integerList.remove(0));

                notify();

                Thread.sleep(1000);
            }
        }
    }

}
